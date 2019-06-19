package com.johndoe.mycv.screens.work

import androidx.lifecycle.ViewModel
import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.model.Work

class WorkViewModel(val repository: IRepository) : ViewModel() {

    fun getWorkList() : ArrayList<Work> {
        return repository.getWork()
    }
}