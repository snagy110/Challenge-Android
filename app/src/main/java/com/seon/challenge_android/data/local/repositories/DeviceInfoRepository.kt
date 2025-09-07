package com.seon.challenge_android.data.local.repositories

import com.seon.challenge_android.data.local.resolvers.DeviceInfoResolver
import com.seon.challenge_android.domain.interfaces.IDeviceInfoRepository
import com.seon.challenge_android.domain.interfaces.IDeviceInfoResolver

class DeviceInfoRepository(
    private val deviceInfoResolver: IDeviceInfoResolver
) : IDeviceInfoRepository {

    override fun getDeviceID() = deviceInfoResolver.getDeviceID()
}