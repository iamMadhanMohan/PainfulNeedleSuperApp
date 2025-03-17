package com.madhan.feature_hotel.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import com.madhan.feature_hotel.R
import com.madhan.feature_hotel.data.DummyData
import com.madhan.feature_hotel.data.DummyData.hotelLocationList
import com.madhan.feature_hotel.data.HotelLocation
import com.madhan.feature_hotel.ui.widgets.HotelCard
import com.madhan.feature_hotel.utils.routes.HOMESCREEN

@Composable
fun PlaceScreen(navController: NavController) {
    val context = LocalContext.current
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(37.7749, -122.4194), 12f) // Default: San Francisco
    }



    Box(modifier = Modifier.fillMaxSize()) {
        // Google Map
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(isMyLocationEnabled = false)
        ) {
            Marker(
                state = MarkerState(position = LatLng(37.7749, -122.4194)),
                title = "Current Location",
                icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)
            )

            DummyData.hotelLocationList.forEach { hotel ->
                Marker(
                    state = MarkerState(position = hotel.location),
                    title = hotel.name,
                    icon = BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)
                )
            }
        }

//        // Search Bar
        TextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search location / name / country") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(10.dp))
                .shadow(8.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id= R.drawable.search),
                    contentDescription = "Search Icon")
            }
        )

        // Floating Buttons
        Column (
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            FloatingActionButton(onClick = { /* Open Menu */ }, containerColor = Color.White) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
            FloatingActionButton(onClick = { /* Center Location */ }, containerColor = Color.White) {
                Icon(
                    modifier = Modifier.clickable { navController.navigate(HOMESCREEN) },
                    painter = painterResource(id= R.drawable.close),
                    contentDescription = "My Location"
                )
            }
        }

        // Bottom Hotel List
        LazyRow (
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            items(hotelLocationList) { hotel ->
                HotelCard(hotel)
            }
        }
   }
}


@Preview(showBackground = true)
@Composable
fun PlaceScreenPreview(){
    val navController = rememberNavController()
    PlaceScreen(navController = navController)
}