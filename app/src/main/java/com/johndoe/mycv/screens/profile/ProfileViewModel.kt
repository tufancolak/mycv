package com.johndoe.mycv.screens.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.johndoe.mycv.repository.IRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(val repository: IRepository) : ViewModel(), ProfileContract {

    private val disposables = CompositeDisposable()

    private val showErrorView = MutableLiveData<Boolean>()
    private val showProgressView = MutableLiveData<Boolean>()
    private val showProfileView = MutableLiveData<Boolean>()

    init{
        showProgressView.postValue(true)
        showProfileView.postValue(false)
        showErrorView.postValue(false)
    }

    override fun retrieveData() {
        disposables.add(
            this.repository.getData().subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(
                    { result ->
                        showProfileView.postValue(true)
                        showErrorView.postValue(false)
                    },
                    { error ->
                        showProfileView.postValue(false)
                        showErrorView.postValue(true)
                    },
                    { /*Completed */ }
                )!!
        )
    }

    override fun observeProfileView(): MutableLiveData<Boolean> {
        return showProfileView
    }

    override fun observeProgressView(): MutableLiveData<Boolean> {
        return showProgressView
    }

    override fun observeErrorView(): MutableLiveData<Boolean> {
        return showErrorView
    }

    override fun onCleared() {
        disposables.clear()
    }

}