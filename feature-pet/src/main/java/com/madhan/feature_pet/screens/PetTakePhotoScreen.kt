package com.madhan.feature_pet.screens

import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.madhan.core.ui.screen.TakePhotoScreen


@Composable
fun PetTakePhotoScreen(navController: NavHostController) {
    TakePhotoScreen(
        onBackButtonClick = {
            // write your back screen navigation
        },

        onCameraLaunchSuccess = {
            // write your next screen navigation
        }
    )
}


@Preview
@Composable
fun PetTakePhotoScreenPreview() {
    val navController = rememberNavController()
    PetTakePhotoScreen(navController)
}
