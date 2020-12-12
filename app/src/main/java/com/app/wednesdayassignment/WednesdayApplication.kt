package com.app.wednesdayassignment

import android.app.Application
import com.app.wednesdayassignment.di.databaseModules
import com.app.wednesdayassignment.di.networkModules
import com.app.wednesdayassignment.di.repositoryModules
import com.app.wednesdayassignment.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class WednesdayApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@WednesdayApplication)
            androidLogger()
            loadKoinModules(listOf(viewModelModules, repositoryModules, networkModules,databaseModules))
        }
    }
}