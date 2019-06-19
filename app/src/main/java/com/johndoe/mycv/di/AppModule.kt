package com.johndoe.mycv.di


import com.johndoe.mycv.repository.IRepository
import com.johndoe.mycv.repository.Repository
import org.koin.dsl.module

val appModule = module {

    single<IRepository> {
        Repository
    }

}