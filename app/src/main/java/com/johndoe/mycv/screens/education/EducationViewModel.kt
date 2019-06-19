package com.johndoe.mycv.screens.education

import androidx.lifecycle.ViewModel
import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.model.Education

class EducationViewModel(val repository: IRepository) : ViewModel() {

    fun getEducationList() : ArrayList<Education> {
        return repository.getEducation()
    }
}