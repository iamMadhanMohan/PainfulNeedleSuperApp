package com.madhan.adamsuperapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madhan.adamsuperapp.ui.screens.HomeScreen
import com.madhan.feature_bank.navigation.bankNavGraph
import com.madhan.feature_bank.navigation.tinderNavGraph
import com.madhan.feature_delivery.navigation.deliveryNavGraph
import com.madhan.feature_hotel.navigation.hotelNavGraph

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = Screen.Home.route,
        route = "root"
    ) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Uber.route) { ServiceBScreen(navController) } // Uber Home Screen
        deliveryNavGraph(navController) // Delivery Home Screen
        composable(Screen.Pet.route) { ServiceBScreen(navController) } // Pet Home Screen
        tinderNavGraph(navController) // IBank NavGraph
        bankNavGraph(navController) // IBank NavGraph
        hotelNavGraph(navController) // Hotel NavGraph
    }
}
