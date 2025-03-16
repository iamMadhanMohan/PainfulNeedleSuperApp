package com.madhan.feature_delivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.madhan.feature_delivery.R
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import androidx.compose.foundation.layout.fillMaxSize // If you don't already have it
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.google.android.gms.maps.model.CameraPosition
import com.google.maps.android.compose.MapProperties
import com.madhan.feature_delivery.ui.components.HomeIcon
import com.madhan.feature_delivery.ui.components.MapContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapSearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    //HomeIcon()
                    IconButton(onClick = { /*Implement the mapTypes*/ }) {
                        Icon(painterResource(id = R.drawable.menu), contentDescription = "Filter")
                    }
                }
                TopAppBar(
                    title = { Text("Search") },
                    actions = {
                        IconButton(onClick = { /* Handle filter click */ }) {
                            Icon(painterResource(id = R.drawable.search_image), contentDescription = "Filter")
                        }
                    }
                )

                Column(modifier = Modifier.weight(1f)) {
                    // Google Map Implementation
                    // Using markerPosition parameter
                    val markerPosition = remember { mutableStateOf<LatLng?>(null) }

                   // Replace the Text Button with the Image Button
                    IconButton(onClick = { markerPosition.value = LatLng(37.4221, -122.0841) }) {
                        Image(
                            painter = painterResource(id = R.drawable.floating_button), // Replace with your image resource
                            contentDescription = "",
                            modifier = Modifier
                                .size(48.dp) // Adjust size as needed
                                .clip(RoundedCornerShape(8.dp)) // Optional: Add rounded corners
                        )
                    }
                    MapContent(markerPosition = markerPosition.value)

                    // Location Button
                    FloatingActionButton(
                        onClick = { /* Handle location click */ },
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Icon(Icons.Filled.LocationOn, contentDescription = "My Location")
                    }
                }

                // Bottom Driver Cards
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    DriverCard("Jenny Jones", 4.8f, 4.5f, R.drawable.delivery_guy)
                    DriverCard("Sacha Down", 4.8f, 4.5f, R.drawable.group_2_1)
                }
            }
        }
    }
}


@Composable
fun UserMarker(name: String, rating: Float, distance: Float, imageRes: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(text = name, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun DriverCard(name: String, rating: Float, distance: Float, imageRes: Int) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .padding(4.dp),
        //elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = name,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
            )
            Text(text = name, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(id = R.drawable.star),
                    contentDescription = "Rating",
                    tint = Color.Yellow,
                    modifier = Modifier.size(16.dp) // Adjust the size as needed
                )
                Text(text = "$rating")
            }
            Text(text = "$distance Mile Nearby")
        }
    }
}

@Composable
fun MapTypeSwitcher() {
    var mapType by remember { mutableStateOf(com.google.maps.android.compose.MapType.NORMAL) } // Use the correct MapType
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(LatLng(37.4221, -122.0841), 10f) // Example: Mountain View, CA
    }

    Column(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.weight(1f), // Take up most of the space
            cameraPositionState = cameraPositionState,
            properties = MapProperties(mapType = mapType) // Use the correct MapType
        )

        Row(modifier = Modifier.padding(8.dp)) {
            Button(onClick = { mapType = com.google.maps.android.compose.MapType.NORMAL }) {
                Text("Normal")
            }
            Button(onClick = { mapType = com.google.maps.android.compose.MapType.HYBRID }) {
                Text("Hybrid")
            }
            Button(onClick = { mapType = com.google.maps.android.compose.MapType.SATELLITE }) {
                Text("Satellite")
            }
            Button(onClick = { mapType = com.google.maps.android.compose.MapType.TERRAIN }) {
                Text("Terrain")
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun AfricarScreenPreview() {
    MapSearchScreen()
}