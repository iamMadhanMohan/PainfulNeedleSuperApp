package com.madhan.feature_delivery.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.madhan.feature_delivery.R
import com.madhan.feature_delivery.ui.components.BottomOrangeButton
import com.madhan.feature_delivery.ui.components.CustomBackButton

@Composable
fun OrderSummaryScreen(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.4f) // 40% of the screen
                .background(Color(0xFFFF8000)) // Orange background
                .padding(16.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomBackButton { navController.navigate("order_details") }
                Text(text = "Order", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)

                // Cancel Button with Clickable Modifier
                Text(
                    text = "Cancel",
                    fontSize = 16.sp,
                    color = Color.White,
                    modifier = Modifier.clickable { showDialog = true }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Delivery Man
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.delivery_guy), // profile picture
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Spacer(modifier = Modifier.width(14.dp))
                Column {
                    Text(text = "Delivery-man", fontSize = 16.sp, color = Color.White)
                    Text(text = "John Jones", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Date
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Date", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "20 March, Thu - 14h", fontSize = 16.sp, color = Color.White)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Address
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_mylocation), // location icon
                    contentDescription = "Location",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "261 4th St NW, Atlanta", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "->", fontSize = 14.sp, color = Color.White)
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "1211 Cumberland Rd NE, Atlanta", fontSize = 14.sp, color = Color.White)
            }
        }

        // Delivery Details
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.6f) // 60% of the screen
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(text = "Delivery", fontSize = 18.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(16.dp))

            // Weight
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Weight", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Remove", fontSize = 14.sp, color = Color(0xFFFF8000))
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "$ 15/kg", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "x 5", fontSize = 16.sp, color = Color(0xFFFF8000))
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Dimensions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Dimensions", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "Remove", fontSize = 14.sp, color = Color(0xFFFF8000))
                }
                Column(horizontalAlignment = Alignment.End) {
                    Text(text = "50/50/50", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = "x 1", fontSize = 16.sp, color = Color(0xFFFF8000))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Subtotal
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Subtotal", fontSize = 16.sp)
                Text(text = "$ 75.00", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Delivery Fees
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Delivery fees", fontSize = 16.sp)
                Text(text = "$ 0.00", fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Total Amount
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Total amount", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "$ 75.00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(160.dp))

            // Bottom Button Section
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                BottomOrangeButton("Place Order") {
                    navController.navigate("order_success")
                }
            }
        }
    }

    // Confirmation Dialog (Appears when clicking "Cancel")
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }, // Close dialog on outside click
            title = { Text("Are you sure you want to cancel?") },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        navController.navigate("delivery_men") // Navigate to home if "Yes" is clicked
                    }
                ) {
                    Text("Yes")
                }
            },
            dismissButton = {
                Button(
                    onClick = { showDialog = false } // Close dialog if "No" is clicked
                ) {
                    Text("No")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OrderSummaryPreview() {
    OrderSummaryScreen(rememberNavController())
}
