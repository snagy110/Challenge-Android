package com.seon.challenge_android.presentation.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DeviceIdView(
    modifier: Modifier = Modifier,
    displayText: String
) {
    Text(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        text = "Your encoded device ID:\n$displayText",
        color = Color.White,
        fontSize = 20.sp,
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 1.5.sp,
        textDecoration = TextDecoration.Underline,
        textAlign = TextAlign.Center,
        lineHeight = 48.sp,
        overflow = TextOverflow.Ellipsis,
        softWrap = true,
        maxLines = 2,
        minLines = 1,
        style = TextStyle(
            background = Color.Green,
            shadow = Shadow(color = Color.Gray, blurRadius = 40f)
        )
    )
}