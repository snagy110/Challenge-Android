package com.seon.challenge_android.presentation.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.seon.challenge_android.presentation.viewmodels.DeviceInfoViewModel
import com.seon.challenge_android.utils.ResourceResult
import org.koin.androidx.compose.koinViewModel

@Composable
fun DeviceInfoView(
    modifier: Modifier = Modifier,
    deviceInfoViewModel: DeviceInfoViewModel = koinViewModel()
) {
    val data = deviceInfoViewModel.encodedDeviceID
    val deviceID = data.collectAsStateWithLifecycle().value

    when (deviceID) {
        is ResourceResult.Error -> {
            DeviceIdView(
                modifier = modifier,
                displayText = deviceID.error
            )
        }

        is ResourceResult.Loading -> {
            DeviceIdView(
                modifier = modifier,
                displayText = "Loading data..."
            )
        }

        is ResourceResult.Success -> {
            DeviceIdView(
                modifier = modifier,
                displayText = deviceID.data ?: "No data"
            )
        }
    }
}