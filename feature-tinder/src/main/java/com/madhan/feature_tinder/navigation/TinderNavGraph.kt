package com.madhan.feature_bank.navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.madhan.feature_tinder.screens.AddProfileScreen03
import com.madhan.feature_tinder.screens.EnableLocationScreen04
import com.madhan.feature_tinder.screens.PictureChoiceScreen01
import com.madhan.feature_tinder.screens.ProfileScreen07
import com.madhan.feature_tinder.screens.TakePhotoScreen02
import com.madhan.feature_tinder.screens.TinderDisplayScreen06
import com.madhan.feature_tinder.screens.TinderScreen00
import com.madhan.feature_tinder.screens.TutorialScreen05
import com.madhan.feature_tinder.screens.UpdateProfileScreen03
import com.madhan.feature_tinder.viewmodel.ProfileViewModel


fun NavGraphBuilder.tinderNavGraph(
    navController: NavController
){
    navigation(
        startDestination = "tinder_home",
        route = "tinder",
    ) {

        // Get the NavBackStackEntry for the "tinder" navigation graph
//        val navBackStackEntry = navController.getBackStackEntry("tinder")
        // Create the ProfileViewModel scoped to the "tinder" navigation graph
//        val viewModel: ProfileViewModel = viewModel(navBackStackEntry)

        composable("tinder_home") { TinderScreen00(navController = navController) }
        composable("picture_choice") { PictureChoiceScreen01(navController = navController) }
        composable("take_photo") { TakePhotoScreen02(navController = navController) }
        composable("add_profile") { AddProfileScreen03(navController = navController) }
        composable("enable_location") { EnableLocationScreen04(navController = navController) }
        composable("tutorial_screen") { TutorialScreen05(navController = navController) }
        var viewModel: ProfileViewModel? = null
        composable("tinder_display_screen") {
           viewModel = viewModel ?: viewModel()
            TinderDisplayScreen06(
                navController = navController,
                viewModel = viewModel!! // Pass the shared viewModel
            )
        }
        composable("profile_screen") {
            viewModel = viewModel ?: viewModel()
            ProfileScreen07(
                navController = navController,
                viewModel = viewModel!! // Pass the shared viewModel
            ) }
    }
}
