package com.madhan.feature_hotel.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_hotel.R
import com.madhan.feature_hotel.data.DummyData
import com.madhan.feature_hotel.ui.widgets.CustomHotelCard
import com.madhan.feature_hotel.ui.widgets.CustomTitleText
import com.madhan.feature_hotel.ui.widgets.HotelSearchCard
import com.madhan.feature_hotel.ui.widgets.IconTextRow
import com.madhan.feature_hotel.utils.customColors
import com.madhan.feature_hotel.utils.routes.FILTERSCREEN
import com.madhan.feature_hotel.utils.routes.HOTELDETAILSCREEN
import com.madhan.feature_hotel.utils.routes.ORDERSCREEN
import com.madhan.feature_hotel.utils.routes.PLACESCREEN

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        // State to control HotelSearchCard visibility
        var showSearchCard by remember { mutableStateOf(false) }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .clickable(enabled = showSearchCard) { showSearchCard = false }
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
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
                            onClick = { showSearchCard = !showSearchCard },
                            modifier = Modifier
                                .align(Alignment.TopStart)
                                .background(if (!showSearchCard) Color.White else customColors.orange),
                           colors = IconButtonDefaults.filledIconButtonColors(
                               containerColor = if (!showSearchCard) customColors.orange else Color.White,

                                )
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(id = R.drawable.home), // Home icon
                                contentDescription = "Home Icon",
                              tint = if (!showSearchCard) Color.White else customColors.orange
                            )
                        }
                        // Show Hotel Search Card only when showSearchCard is true
                        if (showSearchCard) {
                                HotelSearchCard(
                                    modifier = Modifier,
                                    onClick = { navController.navigate(PLACESCREEN) } //Opens map
                                )
                        }
                    }
                }
                // Favorites and Orders Row
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(customColors.orange),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        IconTextRow(
                            icon = painterResource(id = R.drawable.heart),
                            text = "Favorites",
                            textSize = 16.sp,
                            textColor = Color.White,
                            iconSize = 24.dp,
                            iconTint = Color.White
                        )

                        IconTextRow(
                            modifier = Modifier
                                .clickable { navController.navigate(ORDERSCREEN) },
                            icon = painterResource(id = R.drawable.file),
                            text = "Orders",
                            textSize = 16.sp,
                            iconSize = 24.dp,
                            textColor = Color.White,
                            iconTint = Color.White,
                        )
                    }
                }
                // Spacer after icons
                item { Spacer(modifier = Modifier.height(16.dp)) }
                // Recommended Hotels Title
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomTitleText(
                            text = "Recommended Hotels",
                            fontSize = 18.sp,
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                        //Filter button
                        IconButton(
                            onClick = {navController.navigate(FILTERSCREEN)}, //Go to filter screen
                            enabled = true,
                            colors = IconButtonDefaults.filledIconButtonColors (
                               containerColor =  Color.Transparent,
                                contentColor = customColors.orange
                            )
                        ) {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                painter = painterResource(R.drawable.filter),
                                contentDescription = "filter",
                                tint =  customColors.orange

                            )
                        }
                    }
                }

                // Recommended Hotels List
                items(DummyData.hotelList) { hotel ->
                    CustomHotelCard(
                        modifier = Modifier.clickable { navController.navigate(HOTELDETAILSCREEN) },
                        backgroundImage = painterResource(id = hotel.imageResId),
                        hotelType = hotel.hotelType,
                        hotelLocation = hotel.hotelLocation,
                        hotelRating = hotel.hotelRating,
                        hotelDistance = hotel.hotelDistance,
                        hotelPrice = hotel.hotelPrice,
                        isSelected = remember { mutableStateOf(false) }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}