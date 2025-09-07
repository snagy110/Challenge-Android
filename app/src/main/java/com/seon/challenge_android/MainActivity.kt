package com.seon.challenge_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.seon.challenge_android.presentation.views.DeviceInfoView
import com.seon.challenge_android.ui.theme.ChallengeAndroidTheme
import com.seon.infolib.DeviceInfo
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            println("Device ID: ${DeviceInfo().getDeviceId(this)}")
            ChallengeAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DeviceInfoView(
                        modifier = Modifier.padding(innerPadding),
                        deviceInfoViewModel = koinViewModel()
                    )
                }
            }
        }
    }
}