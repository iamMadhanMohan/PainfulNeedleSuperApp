package com.madhan.adamsuperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.madhan.adamsuperapp.ui.theme. AdamSuperAppTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.madhan.feature_hotel.ui.screens.OnboardingScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AdamSuperAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   OnboardingScreen(
                       paddingValues = innerPadding
                   )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun OnboardingPreview() {
    AdamSuperAppTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            OnboardingScreen(
                paddingValues = innerPadding
            )
        }
    }
}