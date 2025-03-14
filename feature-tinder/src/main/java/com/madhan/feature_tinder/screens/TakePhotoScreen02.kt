package com.madhan.feature_tinder.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.madhan.feature_tinder.R

@Composable
fun TakePhotoScreen02(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_camera),
                contentDescription = ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TakePhotoScreen02Preview() {
    TakePhotoScreen02()
}