//package com.seon.challenge_android.utils
//
//import android.annotation.SuppressLint
//import android.content.Context
//import android.provider.Settings
//import java.util.Base64
//import kotlin.io.encoding.ExperimentalEncodingApi
//
//object DeviceInfo {
//
//    @OptIn(ExperimentalEncodingApi::class)
//    @SuppressLint("HardwareIds") // https://stackoverflow.com/a/46321721/15070004
//    fun getDeviceId(context: Context): String {
//        var returnId = ""
//        val deviceId = Settings.Secure.getString(
//            context.contentResolver,
//            Settings.Secure.ANDROID_ID
//        )
//        deviceId?.let {
//            runCatching {
//                returnId =
//                    Base64.getEncoder().encode(
//                        deviceId.toByteArray()
//                    ).decodeToString()
//            }
//        }
//
//        return returnId
//    }
//}