package com.madhan.feature_uber.Screens.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madhan.feature_uber.Screens.Model.Driver
import com.madhan.feature_uber.Screens.Model.Location
import com.madhan.feature_uber.Screens.Model.VehicleType
import com.madhan.feature_uber.Screens.vm.SharedViewModel

@Composable
fun RideConfirmationScreen(
    viewModel: SharedViewModel,
    onBackClick: () -> Unit,
    onCancelRide: () -> Unit,
    onOrderClick: () -> Unit,
    onSharePickup: () -> Unit,
    onShareDestination: () -> Unit,
    onEditPickup: () -> Unit,
    onEditDestination: () -> Unit,
    sharedViewModel: SharedViewModel
) {


    val orange = Color(0xFFFF7D1E)
    val lightGray = Color(0xFFF5F5F5)
    val mediumGray = Color(0xFFAAAAAA)
    val darkGray = Color(0xFF9E9E9E)
    val blue = Color(0xFF2196F3)
    val green = Color(0xFF4CAF50)

    val selectedDriver = viewModel.selectedDriver
    val pickup = viewModel.pickupLocation
    val destination = viewModel.destinationLocation

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Color.LightGray)
            ) {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(Color.White, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = orange
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 16.dp)
                        .width(40.dp)
                        .height(4.dp)
                        .background(Color.White, RoundedCornerShape(2.dp))
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Your car",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                TextButton(onClick = onCancelRide) {
                    Text(
                        text = "Cancel Ride",
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Cancel",
                        tint = Color.Gray,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            selectedDriver?.let { driver ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(30.dp)
                        )
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = driver.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Icon(
                                imageVector = Icons.Default.Star,
                                contentDescription = null,
                                tint = Color(0xFFFFB800),
                                modifier = Modifier.size(16.dp)
                            )

                            Text(
                                text = driver.rating.toString(),
                                color = Color.Gray,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 2.dp)
                            )
                        }

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Text(
                                text = driver.car,
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                            Text(
                                text = " ${driver.carColor}",
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }
                    }

                    Column(horizontalAlignment = Alignment.End) {
                        Text(
                            text = "Estimate",
                            color = Color.Gray,
                            fontSize = 12.sp
                        )
                        Text(
                            text = driver.estimatedPriceRange,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(top = 4.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 4.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = null,
                                tint = Color.Gray,
                                modifier = Modifier.size(14.dp)
                            )
                            Text(
                                text = "${driver.estimatedTime} min",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(start = 2.dp)
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Destination location",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                if (destination != null) {
                    LocationCard(
                        location = destination,
                        onShareClick = onShareDestination,
                        onEditClick = onEditDestination,
                        iconBackgroundColor = green
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Text(
                    text = "Pick up location",
                    color = Color.Gray,
                    fontSize = 12.sp
                )
                if (pickup != null) {
                    LocationCard(
                        location = pickup,
                        onShareClick = onSharePickup,
                        onEditClick = onEditPickup,
                        iconBackgroundColor = blue
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onOrderClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(containerColor = orange),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Order",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun LocationCard(
    location: Location,
    onShareClick: () -> Unit,
    onEditClick: () -> Unit,
    iconBackgroundColor: Color
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = location.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = location.address,
                fontSize = 14.sp
            )
//            Text(
//                text = location.city,
//                fontSize = 14.sp
//            )
        }

        IconButton(
            onClick = onShareClick,
            modifier = Modifier
                .size(36.dp)
                .border(1.dp, Color.LightGray, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share location",
                tint = Color.Gray,
                modifier = Modifier.size(16.dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        IconButton(
            onClick = onEditClick,
            modifier = Modifier
                .size(36.dp)
                .background(iconBackgroundColor, CircleShape)
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit location",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RideConfirmationScreenPreview() {
//    MaterialTheme {
//        val previewViewModel = SharedViewModel().apply {
//            selectedDriver = Driver(
//                id = "1",
//                name = "Gabriel F.",
//                rating = 4.8,
//                car = "Peugeot 308",
//                carColor = "Red",
//                estimatedTime = 3,
//                estimatedPriceRange = "$50",
//                vehicleType = VehicleType.CAR
//            )
//            pickupLocation = Location(
//                id = "home",
//                name = "Home",
//                address = "28 Orchard Road",
//                coordinates = Pair(-26.2041, 28.0473)
//            )
//            destinationLocation = Location(
//                id = "work",
//                name = "Work",
//                address = "28 Broad Street",
//                coordinates = Pair(-26.2041, 28.0573)
//            )
//        }
//
//        RideConfirmationScreen(
//            viewModel = previewViewModel,
//            onBackClick = {},
//            onCancelRide = {},
//            onOrderClick = {},
//            onSharePickup = {},
//            onShareDestination = {},
//            onEditPickup = {},
//            onEditDestination = {},
//            sharedViewModel = sharedViewModel
//        )
//    }
}