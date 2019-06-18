package com.johndoe.mycv.di


import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.Repository
import com.johndoe.mycv.screens.education.EducationViewModel
import com.johndoe.mycv.screens.profile.ProfileViewModel
import com.johndoe.mycv.screens.work.WorkExperienceViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single<IRepository> {
        Repository()
    }

    // ViewModel
    viewModel {
        ProfileViewModel(get())
    }
    viewModel {
        EducationViewModel(get())
    }
    viewModel {
        WorkExperienceViewModel(get())
    }
}