package com.johndoe.mycv.screens.education

import com.johndoe.mycv.repository.model.Education

interface EducationContract {
    fun getEducationList() : ArrayList<Education>
}