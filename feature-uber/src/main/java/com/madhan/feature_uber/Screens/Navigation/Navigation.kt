package com.madhan.feature_uber.Screens.Navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madhan.feature_uber.Screens.Model.AppConstants
import com.madhan.feature_uber.Screens.ui.*
import com.madhan.feature_uber.Screens.vm.SharedViewModel
import java.time.ZoneOffset

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun SetupNavGraph(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    onBackToHome: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = "transport"
    ) {
        composable("transport") {
            TransportScreen(
                onLoginClick = { navController.navigate("permission") },
                onBackHomeClick = onBackToHome
            )
        }
        composable("permission") {
            PermissionScreen(
                onBackClick = { navController.popBackStack() },
                onLetsGoClick = { navController.navigate("set_destination") {
                    popUpTo(0) { inclusive = true }
                } }
            )
        }
        composable("set_destination") {
            DestinationScreen(
                onLocationSelected = { location ->
                    sharedViewModel.destinationLocation = location
                    navController.navigate("set_pickup")
                },
                onBackClick = { navController.popBackStack() },
                onCalendar = { navController.navigate("calendar") }
            )
        }
        composable("set_pickup") {
            PickUpScreen(
                onProceed = { location ->
                    sharedViewModel.pickupLocation = location
                    navController.navigate("ride_options")
                },
                onBackClick = { navController.popBackStack() },
                onCalendar = { navController.navigate("calendar") }
            )
        }
        composable("ride_options") {
            RideOptionsScreen(
                onBackClick = { navController.popBackStack() },
                onDriverSelected = { driver ->
                    sharedViewModel.selectedDriver = driver
                    navController.navigate("ride_confirmation")

                },
                viewModel = sharedViewModel
            )
        }
        composable("ride_confirmation") {
            RideConfirmationScreen(
                sharedViewModel = sharedViewModel,
                onBackClick = { navController.popBackStack() },
                onCancelRide = { navController.popBackStack() },
                onOrderClick = { navController.navigate("rating")
                { popUpTo(0) {
                    inclusive = true
                } }
                               },
                viewModel = sharedViewModel,
                onSharePickup = { navController.navigate("rating") },
                onShareDestination = { navController.navigate("rating") },
                onEditPickup = { navController.navigate("set_destination") },
                onEditDestination = { navController.navigate("set_pickup") }
            )
        }
        composable("rating") {
            RideRatingScreen(
                onBackClick = { navController.popBackStack() },
                onProceed = { navController.navigate("payment") },
                viewModel = sharedViewModel, // Pass viewModel
            )
        }
        // In Navigation.kt
        composable("calendar") {
            DelayedTripDateTimeScreen(
                onBackClick = { navController.popBackStack() },
                onDateTimeConfirmed = { date, time ->
                    sharedViewModel.selectedDateTime = Pair(
                        date.atTime(time).toEpochSecond(ZoneOffset.UTC) * 1000,
                        date.atTime(time).plusMinutes(30).toEpochSecond(ZoneOffset.UTC) * 1000
                    )
                    navController.popBackStack()
                }
            )
        }

        composable("payment") {
            PaymentScreen(
                onPayClick = { navController.navigate("transport") },
                onHomeClick = onBackToHome,
                viewModel = sharedViewModel,
                balance = 5523.26,
                paymentAmount = 9.50,
                paymentMethods = listOf( )

            )
        }
    }
}