package com.hopcierge.githubkoinktor

import android.app.Application
import com.hopcierge.githubkoinktor.di.appModule
import com.hopcierge.githubkoinktor.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                appModule,
                repositoryModule
            )
        }
    }
}