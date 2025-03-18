package com.madhan.feature_pet.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_pet.R
import com.madhan.feature_pet.data.DummyData

@Composable
fun PetCarePersonListScreen(
    navController: NavHostController,
    selectedStartDate: String = "Choose Dates",
    selectedEndDate: String = "",
    onGuardSelected: (String) -> Unit
) {
    val petCareProviders = DummyData.petCareProviders

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background Image with Home Button
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(261.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pet_background),
                contentDescription = "Pet Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            IconButton(
                onClick = { navController.navigate("start") },
                modifier = Modifier.align(Alignment.TopStart)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home Icon",
                    tint = Color.White
                )
            }
        }

        // Search Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
                .clip(RoundedCornerShape(12.dp))
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Johannesburg, 1 Road Ubuntu", fontWeight = FontWeight.Bold)
                    Icon(
                        painter = painterResource(id = R.drawable.ic_location),
                        contentDescription = "Location",
                        tint = Color(0xFFFF8C00)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(text = "CHOOSE DATES", fontSize = 12.sp, color = Color.Gray)
                        Text(
                            text = "$selectedStartDate - $selectedEndDate",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {
                                navController.navigate("choose_date")
                            }
                        )
                    }
                    Column {
                        Text(text = "NUMBERS OF DOGS", fontSize = 12.sp, color = Color.Gray)
                        Text(text = "1", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BasicTextField(
                        value = "",
                        onValueChange = {},
                        modifier = Modifier.weight(1f),
                        decorationBox = { innerTextField ->
                            if ("" == "") {
                                Text("Search location / name", color = Color.Gray, fontSize = 14.sp)
                            }
                            innerTextField()
                        }
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = { /* Search action */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8C00)),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Search", fontSize = 16.sp, color = Color.White)
                }
            }
        }

        // Favorites and Orders Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(96.dp)
                .background(Color(0xFFFF8C00)),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_heart),
                    contentDescription = "Favorites",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Favorites", fontSize = 16.sp, color = Color.White)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.file),
                    contentDescription = "Orders",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Orders", fontSize = 16.sp, color = Color.White)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title & Filter Button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Guardians",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { navController.navigate("filter") },
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color(0xFFFF8C00)
                )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = "Filter",
                    tint = Color(0xFFFF8C00)
                )
            }
        }

        // List of Pet Care Providers
        LazyColumn(modifier = Modifier.padding(horizontal = 16.dp)) {
            items(petCareProviders) { provider ->
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onGuardSelected(provider.name)
                            navController.navigate("order/${provider.name}/$selectedStartDate/$selectedEndDate")
                        }
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxWidth()) {
                            Image(
                                painter = painterResource(id = provider.imageResId),
                                contentDescription = "Profile Picture",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)),
                                contentScale = ContentScale.Crop
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.ic_heart),
                                contentDescription = "Favorite",
                                tint = Color.Red,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(12.dp)
                                    .size(24.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = provider.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text(text = provider.location, fontSize = 14.sp, color = Color.Gray)
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PetCarePersonListScreenPreview() {
    val navController = rememberNavController()
    PetCarePersonListScreen(navController, "Choose Dates", "", onGuardSelected = {})
}
