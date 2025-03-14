package com.madhan.feature_tinder.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.madhan.feature_tinder.R

@Composable
fun EnableLocationScreen04(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.img_tinder_screen_04),
            contentDescription = ""
        )
        Text(
            text = "Enable geolocation"
        )
        Text(
            text = "To propose profiles near you, you must activate localization"
        )
        Button(
            onClick = {}
        ) {
            Text(
                text = "Activate"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EnableLocationScreen04Preview() {
    EnableLocationScreen04()
}