package com.madhan.feature_pet.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.NavHost
import com.madhan.feature_pet.screens.*

fun NavGraphBuilder.petNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "start",
        route = "pet"  // This allows the main app to recognize this module
    ) {
        composable("start") { StartScreen(navController) }
        composable("your_dog_details") { YourDogDetails(navController) }
        composable("filter") { FilterScreen(navController) }
        composable("photo") { PetTakePhotoScreen(navController) }
        composable("dog_list") { DogListScreen(navController) }
        composable("pet_care_list") { PetCarePersonListScreen(navController) }
    }
}
