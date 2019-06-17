package com.johndoe.mycv

import android.app.Application
import org.koin.core.context.startKoin

class TestBaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{

        }
    }
}