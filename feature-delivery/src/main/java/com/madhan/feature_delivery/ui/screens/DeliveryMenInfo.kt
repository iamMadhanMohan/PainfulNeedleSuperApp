package com.madhan.feature_delivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.madhan.feature_delivery.R
import androidx.compose.ui.graphics.Brush
import com.madhan.feature_delivery.ui.components.HomeIcon

@Composable
fun DeliveryMenInfo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
               // HomeIcon()
            }

            // Main Content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {

                // Gradient Mask
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(353.dp) // Adjust height as needed
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(
                                    Color.White.copy(alpha = 0f),
                                    Color.White.copy(alpha = 1f)
                                )
                            )
                        )
                ) {
                    // Background Image with Mask
                    Image(
                        painter = painterResource(id = R.drawable.mask_group),
                        contentDescription = "Delivery Image",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                }

                // Foreground Content
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(230.dp)) // Adjust based on mask height

                    // Content Card (Scrollable)
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(8.dp))
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Marietta, 1 Park Plaza",
                                Modifier.navigationBarsPadding(),
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "CHOOSE DATES")
                                Text(text = "KG")
                                Text(text = "DIMENSIONS")
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(text = "20 Mar - 10h")
                                Text(text = "5")
                                Text(text = "50/50/50")
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            // Search Bar
                            OutlinedTextField(
                                value = "",
                                onValueChange = {},
                                placeholder = { Text("Search location/name") },
                                modifier = Modifier.fillMaxWidth(),
                                trailingIcon = {
                                    IconButton(onClick = { /* Handle search */ }) {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "Search"
                                        )
                                    }
                                }
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Favorites and Orders Buttons
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                Button(onClick = { /* Handle Favorites */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8000)),
                                    modifier = Modifier.width(136.dp)) {
                                    Image(
                                        painter = painterResource(id = R.drawable.favorites),
                                        modifier = Modifier
                                            .size(20.dp)
                                            .clip(RoundedCornerShape(8.dp)),
                                        contentDescription = "Favourites",
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text(text = "Favorites")
                                }
                                Button(onClick = { /* Handle Orders */ },
                                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8000)),
                                    modifier = Modifier.width(136.dp)) {

                                    Image(
                                        painter = painterResource(id = R.drawable.orders),
                                        modifier = Modifier
                                            .size(20.dp)
                                            .clip(RoundedCornerShape(8.dp)),
                                        contentDescription = "Favourites",
                                    )
                                    Spacer(modifier = Modifier.width(8.dp))

                                    Text(text = "Orders")
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Delivery men",
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.width(190.dp))
                            IconButton(onClick = { /* Handle filters */ }) {
                                Icon(
                                    imageVector = Icons.Default.Info,
                                    contentDescription = "Filters",
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))
                        }

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .verticalScroll(rememberScrollState()) // Make content scrollable
                            ) {

                                // delivery men image
                                Image(
                                    painter = painterResource(id = R.drawable.delivery_guy),
                                    contentDescription = "Delivery Guy",
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(RoundedCornerShape(8.dp)),
                                    contentScale = ContentScale.Crop
                                )

                                Spacer(modifier = Modifier.width(16.dp))


                                Spacer(modifier = Modifier.height(8.dp))

                                // Cleaner Details (Replace with actual data)
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    //verticalAlignment = Alignment.CenterVertically
                                ) {

                                    Column {
                                        Text(text = "Vander", fontWeight = FontWeight.Bold)
                                        Text(text = "Marrieta", fontSize = 14.sp)
                                    }

                                    Spacer(modifier = Modifier.height(12.dp))

                                    // Rating, Distance, and Price
                                    Row(horizontalArrangement = Arrangement.SpaceAround) {
                                        Text(text = "4.8 ⭐")
                                        Spacer(modifier = Modifier.width(90.dp))
                                        Text(text = "500 m")
                                        Spacer(modifier = Modifier.width(90.dp))
                                        Text(text = "$ 15/kg")
                                    }
                                }
                            }
                        }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DeliveryMenPreview() {
    DeliveryMenInfo()
}