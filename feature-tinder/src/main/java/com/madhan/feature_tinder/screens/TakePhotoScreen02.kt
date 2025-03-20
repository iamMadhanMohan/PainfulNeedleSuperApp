package com.madhan.feature_tinder.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.madhan.core.ui.screen.TakePhotoScreen

@Composable
fun TakePhotoScreen02(
    modifier: Modifier = Modifier,
    navController: NavController? = null
) {
    TakePhotoScreen(
        onBackButtonClick = {
            // write navigation to previous screen
        },
        onCameraLaunchSuccess = {
            // write navigation to next screen
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TakePhotoScreen02Preview() {
//    TakePhotoScreen02()
}