package com.madhan.adamsuperapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.madhan.adamsuperapp.ui.screens.HomeScreen
import com.madhan.feature_bank.navigation.bankNavGraph
import com.madhan.feature_bank.navigation.tinderNavGraph
import com.madhan.feature_delivery.navigation.deliveryNavGraph
import com.madhan.feature_hotel.navigation.hotelNavGraph
import com.madhan.feature_uber.Screens.Navigation.SetupNavGraph
import com.madhan.feature_pet.navigation.petNavGraph

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
        composable(Screen.Hotel.route) { ServiceAScreen(navController) }
        navigation(
            startDestination = "uber_main",
            route = Screen.Uber.route
        ) {
            composable("uber_main") {
                // Create a nested NavController specifically for the Uber feature
                val uberNavController = rememberNavController()
                SetupNavGraph(uberNavController)
            }// Hotel Home Screen

        composable(Screen.Delivery.route) { ServiceBScreen(navController) } // Delivery Home Screen
        petNavGraph(navController) // Pet Home Screen
        composable(Screen.Tinder.route) { ServiceBScreen(navController) } // Tinder Home Screen
        composable(Screen.Pet.route) { ServiceBScreen(navController) } // Pet Home Screen
        tinderNavGraph(navController) // IBank NavGraph
        bankNavGraph(navController) // IBank NavGraph
        hotelNavGraph(navController) // Hotel NavGraph
    }
}}
