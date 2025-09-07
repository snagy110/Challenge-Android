package com.seon.infolib

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import kotlin.io.encoding.ExperimentalEncodingApi

class DeviceInfo: IDeviceInfo {

    @OptIn(ExperimentalEncodingApi::class)
    @SuppressLint("HardwareIds") // https://stackoverflow.com/a/46321721/15070004
    override fun getDeviceId(context: Context): String = Settings.Secure.getString(
        context.contentResolver,
        Settings.Secure.ANDROID_ID
    )
}