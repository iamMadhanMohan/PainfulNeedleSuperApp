package com.madhan.adamsuperapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madhan.adamsuperapp.ui.screens.HomeScreen
import com.madhan.feature_bank.navigation.bankNavGraph
import com.madhan.feature_hotel.data.vm.FavoriteViewModel
import com.madhan.feature_hotel.navigation.hotelNavGraph

@Composable
fun AppNavigation(navController: NavHostController) {
    // Create the FavoriteViewModel for Favorites
    val favoriteViewModel: FavoriteViewModel = viewModel()
    NavHost(
        navController,
        startDestination = Screen.Home.route,
        route = "root"
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Uber.route) { ServiceBScreen(navController) } // Uber Home Screen
        composable(Screen.Delivery.route) { ServiceBScreen(navController) } // Delivery Home Screen
        composable(Screen.Pet.route) { ServiceBScreen(navController) } // Pet Home Screen
        composable(Screen.Tinder.route) { ServiceBScreen(navController) } // Tinder Home Screen
        bankNavGraph(navController) // IBank NavGraph
        hotelNavGraph(navController, favoriteViewModel) // Hotel NavGraph
    }
}
