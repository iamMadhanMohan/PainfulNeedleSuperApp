package com.madhan.feature_delivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*
import com.madhan.feature_delivery.R
import com.madhan.feature_delivery.ui.components.HomeIcon
import com.madhan.feature_delivery.ui.components.MapContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapSearchScreen(navController: NavController) {
    var mapType by remember { mutableStateOf(MapType.NORMAL) }
    val markerPositions = listOf(
        LatLng(33.7756, -84.3963),   // Downtown Atlanta
        LatLng(33.7942, -84.3477),   // Buckhead
        LatLng(33.7333, -84.3780),   // Midtown
        LatLng(33.7627, -84.4225),   // West Midtown
        LatLng(33.8120, -84.3627)    // Lenox
    )

    Box(modifier = Modifier.fillMaxSize().padding(8.dp), contentAlignment = Alignment.TopCenter) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Absolute.SpaceBetween
                ) {
                    HomeIcon(
                        onClick = { navController.navigate("delivery_home") },
                        modifier = Modifier.padding(8.dp),
                    )
                    IconButton(
                        onClick = { mapType = getNextMapType(mapType) },
                        modifier = Modifier
                            .size(28.dp) // Adjusted padding
                            .clip(CircleShape)
                            .background(Color.White) // Background to highlight the icon
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.menu),
                            contentDescription = "Switch Map Type",
                            modifier = Modifier.size(20.dp), // Reduced size
                            tint = Color.Black
                        )
                    }
                }
                Column(modifier = Modifier.weight(1f)) {
                    val cameraPositionState = rememberCameraPositionState {
                        position = CameraPosition.fromLatLngZoom(markerPositions[0], 12f)
                    }

                    GoogleMap(
                        modifier = Modifier.fillMaxSize(),
                        cameraPositionState = cameraPositionState,
                        properties = MapProperties(mapType = mapType)
                    ) {
                        markerPositions.forEach { location ->
                            Marker(
                                state = MarkerState(position = location),
                                title = "Driver Location"
                            )
                        }
                    }
                    FloatingActionButton(
                        onClick = { /* Handle location click */ },
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(Icons.Filled.LocationOn, contentDescription = "My Location")
                    }
                }
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(getDriverList()) { driver ->
                        DriverCard(driver, navController) {
                            navController.navigate("order_details")
                        }
                    }
                }
            }
        }
    }
}

fun getDriverList() = listOf(
    DriverData("Jenny Jones", 4.8f, 4.5f, R.drawable.delivery_guy),
    DriverData("Sacha Down", 4.6f, 3.8f, R.drawable.delivery_guy2),
    DriverData("Johnathan", 4.3f, 3.8f, R.drawable.delivery_guy3),
    DriverData("William", 4.7f, 3.8f, R.drawable.delivery_guy4)
)

data class DriverData(val name: String, val rating: Float, val distance: Float, val imageRes: Int)

@Composable
fun DriverCard(driver: DriverData, navController: NavController, onClick: () -> Unit) {
    Card(
        modifier = Modifier.width(160.dp).padding(4.dp).clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = driver.imageRes),
                contentDescription = driver.name,
                modifier = Modifier.size(80.dp).clip(CircleShape)
            )
            Text(text = driver.name, fontWeight = FontWeight.Bold)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painterResource(id = R.drawable.star),
                    contentDescription = "Rating",
                    tint = Color.Yellow,
                    modifier = Modifier.size(16.dp)
                )
                Text(text = "${driver.rating}")
            }
            Text(text = "${driver.distance} Mile Nearby")
        }
    }
}

fun getNextMapType(currentType: MapType): MapType {
    return when (currentType) {
        MapType.NORMAL -> MapType.SATELLITE
        MapType.SATELLITE -> MapType.TERRAIN
        MapType.TERRAIN -> MapType.HYBRID
        else -> MapType.NORMAL
    }
}

@Preview(showBackground = true)
@Composable
fun AfricarScreenPreview() {
    MapSearchScreen(rememberNavController())
}
