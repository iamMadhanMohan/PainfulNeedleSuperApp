package com.madhan.feature_hotel.ui.nav

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madhan.feature_hotel.ui.screens.FilterScreen
import com.madhan.feature_hotel.ui.screens.HomeScreen
import com.madhan.feature_hotel.ui.screens.HotelDetailScreen
import com.madhan.feature_hotel.ui.screens.OnboardingScreen
import com.madhan.feature_hotel.ui.screens.OrderScreen
import com.madhan.feature_hotel.ui.screens.PlaceScreen
import com.madhan.feature_hotel.utils.routes.FILTERSCREEN
import com.madhan.feature_hotel.utils.routes.HOMESCREEN
import com.madhan.feature_hotel.utils.routes.HOTELDETAILSCREEN
import com.madhan.feature_hotel.utils.routes.HOTELSCREEN
import com.madhan.feature_hotel.utils.routes.ORDERSCREEN
import com.madhan.feature_hotel.utils.routes.PLACESCREEN

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
        composable(PLACESCREEN) { PlaceScreen(
            navController = navController
        )
        }
        composable(HOTELDETAILSCREEN) { HotelDetailScreen(
            navController = navController
        )
        }
        composable(ORDERSCREEN) { OrderScreen(
            navController = navController
        )
        }
    }
}
