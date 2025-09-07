package com.seon.challenge_android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.seon.challenge_android.domain.usecases.DeviceIdEncodeUseCase
import com.seon.challenge_android.utils.ResourceResult
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class DeviceInfoViewModel(
    private val deviceIdEncodeUseCase: DeviceIdEncodeUseCase
) : ViewModel() {

    private val _encodedDeviceID = MutableSharedFlow<ResourceResult<String?>>()
    val encodedDeviceID: StateFlow<ResourceResult<String?>> = getEncodedDeviceId()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000), // Or Lazily, Eagerly
            initialValue = ResourceResult.Loading
        )

    private fun getEncodedDeviceId() = _encodedDeviceID.onStart {
        emit(ResourceResult.Loading)
        try {
            emit(ResourceResult.Success(data = deviceIdEncodeUseCase()))
        } catch (e: Exception) {
            emit(ResourceResult.Error(error = e.message ?: "Error Occurred!"))
        }
    }
}