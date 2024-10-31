package com.example.somekindoffapp

import android.app.Application
import com.example.somekindoffapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        startKoin {
            androidLogger()
            androidContext(applicationContext)
            modules(appModule)
        }
    }
}