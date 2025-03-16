package com.madhan.feature_hotel.ui.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madhan.feature_hotel.ui.screens.FilterScreen
import com.madhan.feature_hotel.ui.screens.HomeScreen
import com.madhan.feature_hotel.ui.screens.OnboardingScreen
import com.madhan.feature_hotel.utils.routes.FILTERSCREEN
import com.madhan.feature_hotel.utils.routes.HOMESCREEN
import com.madhan.feature_hotel.utils.routes.HOTELSCREEN

@Composable
fun AppNavigation(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost (
        navController = navController,
        startDestination = HOTELSCREEN
    ) {
        composable(HOTELSCREEN) {
            OnboardingScreen(
                navController = navController,
                paddingValues = paddingValues
            )
        }
        composable(HOMESCREEN) { HomeScreen(
            navController = navController
        )
        }
        composable(FILTERSCREEN) { FilterScreen(
                navController = navController
            )

        }
    }
}
