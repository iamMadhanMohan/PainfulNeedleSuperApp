package com.madhan.feature_hotel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_hotel.R
import com.madhan.feature_hotel.ui.nav.AppNavigation
import com.madhan.feature_hotel.ui.widgets.CustomHotelCard
import com.madhan.feature_hotel.ui.widgets.CustomTitleText
import com.madhan.feature_hotel.ui.widgets.IconTextRow
import com.madhan.feature_hotel.utils.customColors

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Background Image with Home Icon
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(261.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hotelimg1), // Background image
                        contentDescription = "Hotel Background",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )

                    IconButton(
                        onClick = { /* Handle Home Icon click */ },
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.TopStart),
                        colors = IconButtonDefaults.filledIconButtonColors(
                            containerColor = customColors.orange
                        )
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.home), // Home icon
                            contentDescription = "Home Icon",
                            tint = Color.White
                        )
                    }
                }
            }

            // Spacer after background
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Favorites and Orders Row
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconTextRow(
                        icon = painterResource(id = R.drawable.heartfill),
                        text = "Favorites",
                        iconSize = 24.dp,
                        iconTint = customColors.orange
                    )

                    IconTextRow(
                        icon = painterResource(id = R.drawable.file),
                        text = "Orders",
                        iconSize = 24.dp,
                        iconTint = customColors.orange
                    )
                }
            }

            // Spacer after icons
            item { Spacer(modifier = Modifier.height(16.dp)) }

            // Recommended Hotels Title
            item {
                Text(
                    text = "Recommended Hotels",
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp)
                )
            }

            // Recommended Hotels List
            items(10) { index ->
                CustomHotelCard(
                    backgroundImage = painterResource(
                        id = when (index % 5) {
                            0 -> R.drawable.hotelimg4
                            1 -> R.drawable.hotelimg2
                            2 -> R.drawable.hotelimg5
                            3 -> R.drawable.hotelimg6
                            4 -> R.drawable.hotelimg1
                            else -> R.drawable.hotelimg3
                        }
                    ),
                    hotelType = "Resort Hotel",
                    hotelLocation = "Smyrna",
                    hotelRating = "4.5",
                    hotelDistance = "1.5 km to center",
                    hotelPrice = "$ 50",
                    isSelected = remember { mutableStateOf(false) }
                )
            }
        }
    }
}








//@Composable
//fun HomeScreen(navController: NavController) {
//    val isSelected = remember { mutableStateOf(false) }
//
//    Scaffold { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//
//            //Hotel Card
//            CustomHotelCard(
//                backgroundImage = painterResource(id = R.drawable.hotelimg4),
//                hotelType = "Resort Hotel",
//                hotelLocation = "Smyrna",
//                hotelRating = "4.5",
//                hotelDistance = "1.5 km to center",
//                hotelPrice = "$ 50",
//                isSelected = remember { mutableStateOf(false) }
//            )
//
//        }
//    }
//}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()

        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HomeScreen(
                navController = navController
            )
    }
}