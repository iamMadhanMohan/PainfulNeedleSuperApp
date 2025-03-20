package com.madhan.feature_uber.Screens.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.madhan.feature_uber.Screens.vm.SharedViewModel

@Composable
fun RideRatingScreen(
    viewModel: SharedViewModel, // Add viewModel parameter
    onBackClick: () -> Unit = {},
    onProceed: () -> Unit = {}
){
    var selectedTip by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Map Background (placeholder)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
        )

        // Home icon in the top-left corner
        Box(
            modifier = Modifier
                .padding(16.dp)
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White)
                .align(Alignment.TopStart),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Home,
                contentDescription = "Home",
                tint = Color(0xFFFF6E40)
                ,modifier = Modifier.size(24.dp)
                .clickable { onBackClick() }

            )
        }

        // Destination location card
        Card(
            modifier = Modifier
                .padding(top = 64.dp, start = 64.dp, end = 64.dp)
                .align(Alignment.TopCenter),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
//            Row(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Column {
//                    Text(
//                        text = "Work",
//                        fontSize = 16.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                    Text(
//                        text = "28 Broad Street, Johan...",
//                        fontSize = 14.sp,
//                        color = Color.Gray
//                    )
//                }
//                Icon(
//                    imageVector = Icons.Default.KeyboardArrowRight,
//                    contentDescription = "Details",
//                    tint = Color.Gray
//                )
//            }
        }

//        // Car marker on the map
//        Box(
//            modifier = Modifier
//                .size(40.dp)
//                .align(Alignment.Center)
//                .offset(y = (-40).dp),
//            contentAlignment = Alignment.Center
//        ) {
//            Icon(
//                painter = painterResource(id = android.R.drawable.ic_menu_directions),
//                contentDescription = "Car",
//                tint = Color.Black,
//                modifier = Modifier.size(32.dp)
//            )
//        }

        // Rating card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                // Close button
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color(0xFFFF6E40),
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp)
                        .clickable { /* close the  droable  */ }
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Horizontal line
                    Box(
                        modifier = Modifier
                            .width(40.dp)
                            .height(4.dp)
                            .background(Color.LightGray, RoundedCornerShape(2.dp))
                            .align(Alignment.CenterHorizontally)
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Thank you message
                    Text(
                        text = "Thank you",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Rating message
                    Text(
                        text = "rate your driver",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Star rating
                    ClickableRating()

                    // Comment field
                    // Add this state declaration at the top of your composable
                    var text by remember { mutableStateOf("") }

                    TextField(
                        value = text,  // Use the state variable here
                        onValueChange = { newText -> text = newText },
                        placeholder = { Text("Tell us about your experience") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp)),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color(0xFFF5F5F5),
                            unfocusedContainerColor = Color(0xFFF5F5F5),
                            disabledContainerColor = Color(0xFFF5F5F5),
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Tip question
                    Text(
                        text = "Do you want to tip?",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    // Tip options
                    var selectedTip by remember { mutableStateOf("") }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        TipButton(
                            amount = "$4",
                            isSelected = selectedTip == "$4",
                            onSelect = {
                                selectedTip = "$4"
                                viewModel.selectedTip = 4.0},
                                color = Color(0xFF2196F3)
                        )
                        TipButton(
                            amount = "$10",
                            isSelected = selectedTip == "$10",
                            onSelect = {
                                selectedTip = "$10"
                                viewModel.selectedTip = 10.0},
                            color = Color(0xFF2196F3)
                        )
                        TipButton(
                            amount = "$20",
                            isSelected = selectedTip == "$20",
                            onSelect = {
                                selectedTip = "$20"
                                viewModel.selectedTip = 20.0},
                            color = Color(0xFF2196F3)
                        )
                        TipButton(
                            amount = "$200",
                            isSelected = selectedTip == "$200",
                            onSelect = {
                                selectedTip = "$200"
                                viewModel.selectedTip = 200.0},
                            color = Color(0xFF2196F3)

                        )
                    }

                    // Submit button
                    Button(
                        onClick = { onProceed() },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF9800)
                        ),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = "Submit",
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TipButton(
    amount: String,
    isSelected: Boolean,
    onSelect: () -> Unit,
    color: Color,
    textColor: Color = Color.White,
    hasBorder: Boolean = false
) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color)
            .border(
                width = if (hasBorder) 1.dp else 0.dp,
                color = if (hasBorder) Color.LightGray else Color.Transparent,
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { onSelect() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = amount,
            color = textColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ClickableRating() {
    var selectedRating by remember { mutableStateOf(0) } // Store selected rating

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(bottom = 24.dp)
    ) {
        for (i in 1..5) {
            Icon(
                painter = painterResource(
                    id = if (i <= selectedRating) android.R.drawable.btn_star_big_on
                    else android.R.drawable.btn_star_big_off
                ),
                contentDescription = "Star",
                tint = if (i <= selectedRating) Color(0xFFFF9800) else Color.LightGray,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { selectedRating = i } // Set rating when clicked
            )
        }
    }
}

