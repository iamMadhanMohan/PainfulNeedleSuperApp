package com.madhan.adamsuperapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madhan.adamsuperapp.ui.screens.HomeScreen
import com.madhan.feature_bank.navigation.bankNavGraph

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = Screen.Home.route,
        route = "root"
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Hotel.route) { ServiceAScreen(navController) } // Hotel Home Screen
        composable(Screen.Uber.route) { ServiceBScreen(navController) } // Uber Home Screen
        composable(Screen.Delivery.route) { ServiceBScreen(navController) } // Delivery Home Screen
        composable(Screen.Pet.route) { ServiceBScreen(navController) } // Pet Home Screen
        composable(Screen.Tinder.route) { ServiceBScreen(navController) } // Tinder Home Screen
        bankNavGraph(navController) // IBank NavGraph
    }
}
