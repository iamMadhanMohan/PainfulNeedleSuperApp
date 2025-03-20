package com.madhan.feature_delivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_delivery.R
import com.madhan.feature_delivery.ui.components.HomeIcon
import kotlinx.coroutines.launch
@Composable
fun DeliveryMenInfo(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.mask_group),
            contentDescription = "Delivery Background",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            state = listState // Attach list state for scrolling
        ) {
            item {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HomeIcon(onClick = { navController.navigate("home") })
                    }

                    Spacer(modifier = Modifier.height(94.dp))

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .fillMaxHeight(0.6f),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Marietta, 1 Park Plaza",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 26.sp
                                )
                                IconButton(onClick = { navController.navigate("delivery_address") }) {
                                    Icon(
                                        painter = painterResource(id = android.R.drawable.ic_menu_mylocation),
                                        contentDescription = "Current Location"
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "CHOOSE DATES",
                                    fontWeight = FontWeight.Bold,
                                )
                                Text(text = "KG")
                                Text(
                                    text = "DIMENSIONS",
                                    fontWeight = FontWeight.Bold
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = "20 Mar - 10h",
                                    fontWeight = FontWeight.Bold,
                                    color = Color.Blue, // Make it visually clear it's clickable
                                    modifier = Modifier
                                        .clickable {
                                            navController.navigate("date") // Navigate to the Choose Date screen
                                        }
                                )

                                Text(text = "5")
                                Text(
                                    text = "50/50/50",
                                    modifier = Modifier.clickable {
                                        navController.navigate("parcel")
                                    }
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            OutlinedTextField(
                                value = searchQuery,
                                onValueChange = { searchQuery = it },
                                placeholder = { Text("Search location/name") },
                                modifier = Modifier.fillMaxWidth(),
                                trailingIcon = {
                                    IconButton(onClick = {
                                        // Scroll to "Delivery men" section
                                        coroutineScope.launch {
                                            listState.animateScrollToItem(1) // Adjust index if needed
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "Search"
                                        )
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color(0xFFFF8000), RoundedCornerShape(8.dp)),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Button(
                                    onClick = { navController.navigate("favorites") },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8000)),
                                    modifier = Modifier.width(136.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.favorites),
                                        modifier = Modifier.size(20.dp),
                                        contentDescription = "Favorites"
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = "Favorites")
                                }

                                Button(
                                    onClick = { navController.navigate("orders") },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8000)),
                                    modifier = Modifier.width(136.dp)
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.orders),
                                        modifier = Modifier.size(20.dp),
                                        contentDescription = "Orders"
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = "Orders")
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(7.dp))
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Delivery men",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                    IconButton(onClick = { navController.navigate("filter") }) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter1),
                            contentDescription = "Filter",
                            modifier = Modifier.size(24.dp),
                            tint = Color(0xFFFF8000)
                        )
                    }
                }
            }

            items(
                listOf(
                    Triple("Jenny Jones", 4.8f, R.drawable.delivery_guy),
                    Triple("Sacha Down", 4.6f, R.drawable.delivery_guy2),
                    Triple("Johnathan James", 4.3f, R.drawable.delivery_guy3),
                    Triple("William", 4.7f, R.drawable.delivery_guy4)
                )
            ) { (name, rating, imageRes) ->
                DriverCard1(name, rating, 4.5f, imageRes, navController) {
                    navController.navigate("map_search")
                }
            }
        }
    }
}


@Composable
fun DriverCard1(
    name: String,
    rating: Float,
    distance: Float,
    imageRes: Int,
    navController: NavController,
    onClick: () -> Unit
) {
    var isFavorite by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                // Delivery Person's Image
                Image(
                    painter = painterResource(id = imageRes),
                    contentDescription = name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .width(150.dp)// Ensures width is fully occupied
                        .height(200.dp)  // Adjust height as needed
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop  // Ensures the entire image fits without cropping
                )

                // Favorite Button on Top-Right Corner
                IconButton(
                    onClick = {
                        isFavorite = !isFavorite
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar("Added to Favorites")
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(22.dp)



                ) {
                    Icon(
                        painter = painterResource(id = if (isFavorite) R.drawable.favorites else R.drawable.favorites),
                        contentDescription = "Favorite",
                        tint = if (isFavorite) Color(0xFFFF8000) else Color.Gray

                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Delivery Person's Name
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp)

            Spacer(modifier = Modifier.height(4.dp))

            // Rating Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Rating",
                    tint = Color.Yellow,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "$rating", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Distance Info
            Text(text = "$distance Mile Nearby", fontSize = 14.sp, color = Color.Gray)
        }
    }

    // Snackbar to show "Added to Favorites" message
    SnackbarHost(hostState = snackbarHostState)
}


@Preview(showBackground = true)
@Composable
fun DeliveryMenPreview() {
    DeliveryMenInfo(rememberNavController())
}
