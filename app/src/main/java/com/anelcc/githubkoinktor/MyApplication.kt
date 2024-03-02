package com.anelcc.githubkoinktor

import android.app.Application
import com.anelcc.githubkoinktor.di.appModule
import com.anelcc.githubkoinktor.di.domainModule
import com.anelcc.githubkoinktor.di.repositoryModule
import com.anelcc.githubkoinktor.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule,
                repositoryModule,
                viewModelModule,
                domainModule,
            )
        }
    }
}