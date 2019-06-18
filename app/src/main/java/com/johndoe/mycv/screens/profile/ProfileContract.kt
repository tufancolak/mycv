package com.johndoe.mycv.screens.profile

import androidx.lifecycle.MutableLiveData

interface ProfileContract {

    fun retrieveData()

    fun observeProfileView() : MutableLiveData<Boolean>
    fun observeProgressView() : MutableLiveData<Boolean>
    fun observeErrorView() : MutableLiveData<Boolean>

}