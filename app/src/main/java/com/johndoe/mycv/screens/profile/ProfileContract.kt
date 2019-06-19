package com.johndoe.mycv.screens.profile

import androidx.lifecycle.MutableLiveData
import com.johndoe.mycv.repository.model.Resume

interface ProfileContract {

    fun retrieveData()

    fun observeResumeData() : MutableLiveData<Resume>

    fun observeProfileView() : MutableLiveData<Boolean>
    fun observeProgressView() : MutableLiveData<Boolean>
    fun observeErrorView() : MutableLiveData<Boolean>

}