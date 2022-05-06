package com.matheus.casesportheca.data.remote.di

import com.matheus.casesportheca.BuildConfig
import com.matheus.casesportheca.data.remote.WebServiceFactory.provideOkHttpClient
import com.matheus.casesportheca.data.remote.WebServiceFactory.provideRetrofit
import org.koin.dsl.module

val dataRemoteModule = module {
    single {
        provideRetrofit(
            provideOkHttpClient(
                BuildConfig.DEBUG && BuildConfig.BUILD_TYPE == "debug"
            )
        )
    }
}