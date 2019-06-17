package com.johndoe.mycv

import android.app.Application
import com.johndoe.mycv.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidContext(this@BaseApplication)
            androidLogger()
            modules(appModule)
        }
    }
}