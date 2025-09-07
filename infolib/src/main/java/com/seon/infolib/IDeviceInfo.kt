package com.seon.infolib

import android.content.Context

interface IDeviceInfo {

    fun getDeviceId(context: Context): String
}