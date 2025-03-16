package com.madhan.feature_delivery.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_delivery.ui.screens.DeliveryAddressScreen
import com.madhan.feature_delivery.ui.screens.DeliveryHomeScreen
import com.madhan.feature_delivery.ui.screens.ParcelScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") { DeliveryHomeScreen(navController) }
        composable("parcel") { ParcelScreen(navController) }
        composable("deliveryAddress") { DeliveryAddressScreen(navController) }
    }
}
