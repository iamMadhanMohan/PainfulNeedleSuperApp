package com.madhan.feature_hotel.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
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

fun NavGraphBuilder.hotelNavGraph(
    navController: NavController
){
    navigation(
        startDestination = HOTELSCREEN,
        route = "hotel"
    ) {
        composable(HOTELSCREEN) {
            OnboardingScreen(
                navController = navController
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