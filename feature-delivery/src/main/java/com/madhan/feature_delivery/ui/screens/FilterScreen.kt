package com.madhan.feature_delivery.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_delivery.ui.components.BottomOrangeButton
import com.madhan.feature_delivery.ui.components.CustomBackButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(navController: NavController) {
    var sliderPosition by remember { mutableStateOf(5f) } // initial slider position
    var rating by remember { mutableStateOf(5) } // Rating state, initially set to 5 stars

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomBackButton { navController.navigate("delivery_men") }
            Text(text = "Filters", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            TextButton(onClick = {
                // Clear button logic: Reset all values to initial state
                sliderPosition = 5f
                rating = 0
            }) {
                Text(text = "Clear", fontSize = 15.sp, color = Color(0xFFFF8000))
            }
        }


        Spacer(modifier = Modifier.height(36.dp))
        // Sort By Dropdown
        var expanded by remember { mutableStateOf(false) }
        var selectedOptionText by remember { mutableStateOf("Recommend") }
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = selectedOptionText,
                onValueChange = { },
                label = { Text("Sort by") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.fillMaxWidth().menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                listOf("Recommend", "Price", "Rating").forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedOptionText = selectionOption
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(26.dp))



        // Price/kg Slider with Custom Circle Thumb
        Text(text = "Price/kg")
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 0f..100f,
            colors = SliderDefaults.colors(
                thumbColor = Color.Transparent, // Make thumb invisible (we draw it ourselves)
                activeTrackColor = Color(0xFFFF8000),
                inactiveTrackColor = Color(0xFFDDDDDD)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp) // Adjust height for slider appearance
                .drawWithContent {
                    drawContent() // Draw the default track and background
                    val thumbRadius = 16.dp.toPx() // Thumb outer circle radius
                    val thumbInnerRadius = 8.dp.toPx() // Thumb inner circle radius
                    val centerX = size.width * (sliderPosition - 0f) / (100f - 0f) // Position the thumb based on slider value
                    val centerY = size.height / 2

                    // Draw outer circle of the thumb
                    drawCircle(
                        color = Color(0xFFFF8000),
                        radius = thumbRadius,
                        center = Offset(centerX, centerY)
                    )

                    // Draw inner circle of the thumb (white part)
                    drawCircle(
                        color = Color.White,
                        radius = thumbInnerRadius,
                        center = Offset(centerX, centerY)
                    )
                }
        )


        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("0")
            Text("50")
            Text("100")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Rate Stars
        Text(text = "Rate")
        Spacer(modifier = Modifier.height(8.dp))

        // Clickable Rating (like a slider)
        Row {
            repeat(5) { index ->
                Icon(
                    imageVector = if (index < rating) Icons.Filled.Star else Icons.Outlined.Star,
                    contentDescription = null,
                    tint = if (index < rating) Color(0xFFFF8000) else Color.Gray,
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            rating = index + 1 // Set the rating based on clicked star
                        }
                )
            }
        }

        Spacer(modifier = Modifier.height(370.dp))
        Row(horizontalArrangement = Arrangement.Absolute.Center,
            modifier = Modifier.fillMaxWidth()) {

            // Apply Button
            BottomOrangeButton("Apply") {
                navController.navigate("delivery_men")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterScreenPreview() {
    FilterScreen(rememberNavController())
}
