package com.madhan.feature_tinder.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.madhan.feature_tinder.R

@Composable
fun PictureChoiceScreen01(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img_tinder_screen_01),
            contentDescription = ""
        )
        Text(
            text = "Add your profile picture"
        )
        Text(
            text = "Add photo to personalize your space"
        )
        Button(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_camera),
                contentDescription = ""
            )
            Text(
                text = "Add a picture"
            )
        }
        Button(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_picture),
                contentDescription = ""
            )
            Text(
                text = "Take a picture"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PictureChoiceScreenPreview() {
    PictureChoiceScreen01()
}