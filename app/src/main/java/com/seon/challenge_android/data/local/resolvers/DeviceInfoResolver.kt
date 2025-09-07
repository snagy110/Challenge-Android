package com.seon.challenge_android.data.local.resolvers

import android.content.Context
import com.seon.challenge_android.domain.interfaces.IDeviceInfoResolver
import com.seon.infolib.IDeviceInfo

class DeviceInfoResolver(
    private val context: Context,
    private val deviceInfo: IDeviceInfo
): IDeviceInfoResolver {

    override fun getDeviceID() = deviceInfo.getDeviceId(context)
}