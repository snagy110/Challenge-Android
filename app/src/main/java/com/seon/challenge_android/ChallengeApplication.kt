package com.seon.challenge_android

import android.app.Application
import com.seon.challenge_android.di.appModule
import com.seon.challenge_android.di.infoLibModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ChallengeApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ChallengeApplication)
            modules(appModule, infoLibModule)
        }
    }
}