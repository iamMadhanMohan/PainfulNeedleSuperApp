package com.madhan.feature_hotel.ui.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.madhan.feature_hotel.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.core.ui.components.PrimaryButton
import com.madhan.feature_hotel.data.DummyData.allEquipments
import com.madhan.feature_hotel.ui.widgets.CustomIconButton
import com.madhan.feature_hotel.utils.customColors
import com.madhan.feature_hotel.utils.routes.HOMESCREEN
import com.madhan.feature_hotel.utils.routes.HOTELDETAILSCREEN


//@Composable
//fun FilterScreen(navController: NavController) {
//    val priceRange = remember { mutableFloatStateOf(300f) }
//    val selectedStars = remember { mutableIntStateOf(3) }
//    val selectedEquipments = remember { mutableStateListOf("Tennis") }
//
//
//    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .padding(16.dp)
//        ) {
//            // Header
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                CustomIconButton(
//                    icon = painterResource(id = R.drawable.back_arrow),
//                    onClick = { navController.navigate(HOMESCREEN) },
//                    contentDescription = "back arrow",
//                    iconSize = 20.dp
//                )
//                Text(
//                    text = "Filters",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//                TextButton(onClick = { selectedEquipments.clear() }) {
//                    Text("Clear", color = customColors.orange) // Orange color
//                }
//            }
//
//            Spacer(Modifier.height(20.dp))
//
//            // Price Section
//            Text("Price", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
//            Slider(
//                value = priceRange.floatValue,
//                onValueChange = { priceRange.floatValue = it },
//                valueRange = 0f..600f,
//                colors = SliderDefaults.colors(
//                    thumbColor = customColors.orange,
//                    activeTrackColor = customColors.orange
//                )
//            )
//            Text("$${priceRange.floatValue.toInt()}", fontSize = 16.sp)
//
//            Spacer(Modifier.height(20.dp))
//
//            // Rating Section
//            Text("Rate", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.Center
//            ) {
//                repeat(5) { index ->
//                    Icon(
//                        painter = painterResource(id = if (index < selectedStars.intValue) R.drawable.rate else R.drawable.unrate),
//                        contentDescription = "Star Rating",
//                        tint = if (index < selectedStars.intValue) customColors.orange else Color.Gray,
//                        modifier = Modifier
//                            .size(32.dp)
//                            .clickable { selectedStars.intValue = index + 1 }
//                    )
//                }
//            }
//
//            Spacer(Modifier.height(20.dp))
//
//            // Equipments Section
//            Text("Equipments", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
//            Column {
//                allEquipments.chunked(2).forEach { rowItems ->
//                    Row(modifier = Modifier.fillMaxWidth()) {
//                        rowItems.forEach { equipment ->
//                            Row(
//                                modifier = Modifier.weight(1f),
//                                verticalAlignment = Alignment.CenterVertically
//                            ) {
//                                Text(
//                                    text = equipment,
//                                    fontWeight = if (selectedEquipments.contains(equipment)) FontWeight.Bold else FontWeight.Normal,
//                                    color = if (selectedEquipments.contains(equipment)) customColors.orange else customColors.hotelTextColor
//                                )
//                                Checkbox(
//                                    checked = selectedEquipments.contains(equipment),
//                                    onCheckedChange = {
//                                        if (it) selectedEquipments.add(equipment) else selectedEquipments.remove(equipment)
//                                    },
//                                    colors = CheckboxDefaults.colors(
//                                        checkedColor = customColors.orange,
//                                        uncheckedColor = Color.Gray
//                                    )
//                                )
//                            }
//                        }
//                    }
//                }
//            }
//
//            Spacer(Modifier.height(30.dp))
//
//            // Apply Button
//            Button (
//                onClick = { navController.navigate(HOTELDETAILSCREEN) },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp),
//                colors = ButtonDefaults.buttonColors(containerColor  = Color(0xFFFF6600)),
//                shape = RoundedCornerShape(8.dp)
//            ) {
//                Text("Apply", fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
//            }
//        }
//    }
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun FilterScreenPreview(){
//    val navController = rememberNavController()
//    FilterScreen(navController = navController)
//}

@Composable
fun FilterOptions(
    priceRange: MutableState<Float>,
    selectedStars: MutableState<Int>
) {
    Column {
        // Price Section
        Text("Price", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Slider(
            value = priceRange.value,
            onValueChange = { priceRange.value = it },
            valueRange = 0f..600f,
            colors = SliderDefaults.colors(
                thumbColor = customColors.orange,
                activeTrackColor = customColors.orange
            )
        )
        Text("$${priceRange.value.toInt()}", fontSize = 16.sp)

        Spacer(Modifier.height(20.dp))

        // Rating Section
        Text("Rate", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(5) { index ->
                Icon(
                    painter = painterResource(id = if (index < selectedStars.value) R.drawable.rate else R.drawable.unrate),
                    contentDescription = "Star Rating",
                    tint = if (index < selectedStars.value) customColors.orange else Color.Gray,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable { selectedStars.value = index + 1 }
                )
            }
        }
    }
}

@Composable
fun FilterScreen(navController: NavController) {
    val priceRange = remember { mutableFloatStateOf(300f) }
    val selectedStars = remember { mutableIntStateOf(3) }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomIconButton(
                    icon = painterResource(id = R.drawable.back_arrow),
                    onClick = { navController.navigate(HOMESCREEN) },
                    contentDescription = "back arrow",
                    iconSize = 20.dp
                )
                Text(
                    text = "Filters",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                TextButton(onClick = {
                    priceRange.value = 300f
                    selectedStars.value = 3
                }) {
                    Text("Clear", color = customColors.orange)
                }
            }

            Spacer(Modifier.height(20.dp))

            // Use reusable composable for Price & Rate
            FilterOptions(priceRange, selectedStars)

            Spacer(Modifier.height(30.dp))

            // Use reusable button
            PrimaryButton(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Apply",
                onClick = {/*Do navigation here*/}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    val navController = rememberNavController()
    FilterScreen(navController = navController)
}
