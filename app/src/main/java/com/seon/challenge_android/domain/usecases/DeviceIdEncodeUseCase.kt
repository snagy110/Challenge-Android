package com.seon.challenge_android.domain.usecases

import com.seon.challenge_android.domain.interfaces.IDeviceInfoRepository
import java.util.Base64

class DeviceIdEncodeUseCase(private val deviceInfoRepository: IDeviceInfoRepository) {

    operator fun invoke() =
        runCatching {
            Base64.getEncoder().encode(
                deviceInfoRepository.getDeviceID().toByteArray()
            ).decodeToString()
        }.getOrNull()
}