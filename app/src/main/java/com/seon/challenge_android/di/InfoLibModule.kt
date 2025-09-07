package com.seon.challenge_android.di

import com.seon.infolib.DeviceInfo
import com.seon.infolib.IDeviceInfo
import org.koin.dsl.module

val infoLibModule = module {
    single<IDeviceInfo> { DeviceInfo() }
}

