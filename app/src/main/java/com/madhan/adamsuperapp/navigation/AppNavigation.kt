package com.madhan.adamsuperapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.madhan.adamsuperapp.ui.screens.HomeScreen
import com.madhan.adamsuperapp.ui.screens.SignInScreen
import com.madhan.adamsuperapp.ui.screens.SignUpScreen
import com.madhan.feature_bank.navigation.bankNavGraph
import com.madhan.feature_bank.navigation.tinderNavGraph
import com.madhan.feature_delivery.navigation.deliveryNavGraph
import com.madhan.feature_hotel.data.vm.FavoriteViewModel
import com.madhan.feature_hotel.navigation.hotelNavGraph
import com.madhan.feature_pet.navigation.petNavGraph
import com.madhan.feature_uber.Screens.Navigation.SetupNavGraph
import com.madhan.feature_uber.Screens.vm.SharedViewModel // Import your SharedViewModel

@Composable
fun AppNavigation(navController: NavHostController) {
    // ViewModel for Favorites (Hotel feature)
    val favoriteViewModel: FavoriteViewModel = viewModel()

    // Root NavHost
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        route = "root"
    ) {
        // Super app screens
        composable(Screen.SignIn.route) { SignInScreen(navController) }
        composable(Screen.SignUp.route) {
            SignUpScreen(
                navController = navController,
                onNavigateToSignIn = { navController.navigate(Screen.SignIn.route) }
            )
        }
        composable(Screen.Home.route) { HomeScreen(navController) }

        // Uber Feature (Nested Navigation Graph)
        navigation(
            startDestination = "uber_main",
            route = Screen.Uber.route
        ) {
            composable("uber_main") {
                // Uber's internal NavController and SharedViewModel
                val uberNavController = rememberNavController()
                val sharedViewModel: SharedViewModel = viewModel()

                // Uber's navigation graph (see Step 2)
                SetupNavGraph(
                    navController = uberNavController,
                    sharedViewModel = sharedViewModel,
                    onBackToHome = {
                        // Navigate back to super app's Home screen
                        navController.navigate(Screen.Home.route) {
                            popUpTo("root") { inclusive = false }
                        }
                    }
                )
            }
        }

        // Other features (Delivery, Pet, etc.)
        deliveryNavGraph(navController)
        petNavGraph(navController)
        tinderNavGraph(navController)
        bankNavGraph(navController)
        hotelNavGraph(navController, favoriteViewModel)
    }
}