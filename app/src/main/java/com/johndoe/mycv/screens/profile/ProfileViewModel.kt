package com.johndoe.mycv.screens.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.model.Resume
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ProfileViewModel(val repository: IRepository) : ViewModel(), ProfileContract {


    private val showErrorView = MutableLiveData<Boolean>()
    private val showProgressView = MutableLiveData<Boolean>()
    private val showProfileView = MutableLiveData<Boolean>()

    private val resumeData = MutableLiveData<Resume>()

    init {
        showProgressView.postValue(true)
        showProfileView.postValue(false)
        showErrorView.postValue(false)
    }

    override fun retrieveData() {
        showProgressView.postValue(true)

        this.repository.getData().subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                { result ->
                    resumeData.postValue(result)
                    showProfileView.postValue(true)
                    showErrorView.postValue(false)
                    showProgressView.postValue(false)

                },
                { error ->
                    showProfileView.postValue(false)
                    showErrorView.postValue(true)
                    showProgressView.postValue(false)
                },
                { /*Completed */ }
            )!!

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

    override fun observeResumeData(): MutableLiveData<Resume> {
        return resumeData
    }

}