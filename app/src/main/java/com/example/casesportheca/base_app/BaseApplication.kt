package com.example.casesportheca.base_app

import android.app.Application
import org.koin.core.context.startKoin

class BaseApplication {

    class BaseApplication : Application() {
        override fun onCreate() {
            super.onCreate()

        }
    }
}