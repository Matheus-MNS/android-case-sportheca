package com.matheus.casesportheca.base_app

import android.app.Application
import com.matheus.casesportheca.data.remote.di.dataRemoteModule
import com.matheus.casesportheca.feature.world_cup.di.worldCupModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                dataRemoteModule,
                worldCupModule
            ).androidContext(applicationContext)
        }
    }
}
