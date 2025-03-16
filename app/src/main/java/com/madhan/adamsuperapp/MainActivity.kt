package com.madhan.adamsuperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.madhan.adamsuperapp.ui.theme.AdamSuperAppTheme
import com.madhan.feature_tinder.TinderRoute
import com.madhan.feature_tinder.viewmodel.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            AdamSuperAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel: ProfileViewModel = viewModel<ProfileViewModel>()
                    NavHost(
                        navController = navController,
                        startDestination = TinderRoute.TinderScreen.route
                    ) {

                        composable(route = TinderRoute.TinderScreen.route) {
                            com.madhan.feature_tinder.screens.TinderScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = TinderRoute.PictureChoice.route
                        ) {
                            com.madhan.feature_tinder.screens.PictureChoiceScreen01(
                                navController = navController
                            )
                        }
                        composable(
                            route = TinderRoute.TakePhoto.route
                        ) {
                            com.madhan.feature_tinder.screens.TakePhotoScreen02(
                                navController = navController
                            )
                        }
                        composable(
                            route = TinderRoute.AddProfile.route
                        ) {
                            com.madhan.feature_tinder.screens.AddProfileScreen03(
                                navController = navController
                            )
                        }
                        composable(
                            route = TinderRoute.EnableLocation.route
                        ) {
                            com.madhan.feature_tinder.screens.EnableLocationScreen04(
                                navController = navController
                            )
                        }
                        composable(
                            route = TinderRoute.TutorialScreen.route
                        ) {
                            com.madhan.feature_tinder.screens.TutorialScreen05(
                                navController = navController
                            )
                        }
                        composable(
                            route = TinderRoute.TinderDisplayScreen.route
                        ) {
                            com.madhan.feature_tinder.screens.TinderDisplayScreen06(
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                        composable(
                            route = TinderRoute.ProfileScreen.route
                        ){
                            com.madhan.feature_tinder.screens.ProfileScreen07(
                                navController = navController,
                                viewModel = viewModel
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AdamSuperAppTheme {
        Greeting("Android")
    }
}