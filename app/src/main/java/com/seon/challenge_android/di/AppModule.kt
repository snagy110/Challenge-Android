package com.seon.challenge_android.di

import android.content.Context
import com.seon.challenge_android.data.local.repositories.DeviceInfoRepository
import com.seon.challenge_android.data.local.resolvers.DeviceInfoResolver
import com.seon.challenge_android.domain.interfaces.IDeviceInfoRepository
import com.seon.challenge_android.domain.interfaces.IDeviceInfoResolver
import com.seon.challenge_android.domain.usecases.DeviceIdEncodeUseCase
import com.seon.challenge_android.presentation.viewmodels.DeviceInfoViewModel
import com.seon.infolib.IDeviceInfo
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { provideDeviceInfoViewModel(get()) }

    single { provideDeviceInfoResolver(androidContext(), get()) }

    single { provideDeviceInfoRepository(get()) }

    single { provideDeviceIdEncodeUseCase(get()) }
}

private fun provideDeviceInfoResolver(context: Context, deviceInfo: IDeviceInfo): IDeviceInfoResolver =
    DeviceInfoResolver(context = context, deviceInfo = deviceInfo)

private fun provideDeviceInfoRepository(deviceInfoResolver: IDeviceInfoResolver): IDeviceInfoRepository =
    DeviceInfoRepository(deviceInfoResolver = deviceInfoResolver)

private fun provideDeviceIdEncodeUseCase(deviceInfoRepository: IDeviceInfoRepository) =
    DeviceIdEncodeUseCase(deviceInfoRepository = deviceInfoRepository)

private fun provideDeviceInfoViewModel(deviceIdEncodeUseCase: DeviceIdEncodeUseCase) =
    DeviceInfoViewModel(deviceIdEncodeUseCase = deviceIdEncodeUseCase)