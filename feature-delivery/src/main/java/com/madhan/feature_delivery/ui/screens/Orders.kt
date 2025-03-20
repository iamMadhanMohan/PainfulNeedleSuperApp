package com.madhan.feature_delivery.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.feature_delivery.ui.components.CustomBackButton

@Composable
fun OrderScreen(navController: NavController) {
    // Dummy package order details
    val orderId = "123456"
    val packageWeight = "5 KG"
    val packageDimensions = "50x50x50 cm"
    val orderDate = "20 Mar 2025"
    val deliveryStatus = "In Transit"

    Column(modifier = Modifier.fillMaxSize()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomBackButton(onClick = { navController.navigate("delivery_men") })
            Spacer(modifier = Modifier.weight(0.5f)) // Ensure spacer is inside the Row
            Text(text = "Order Details", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.weight(1f))
        }

        // Order Details Section
        OrderSection(orderId, packageWeight, packageDimensions, orderDate, deliveryStatus)
    }
}

@Composable
fun OrderSection(orderId: String, packageWeight: String, packageDimensions: String, orderDate: String, deliveryStatus: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, RoundedCornerShape(8.dp)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Order ID: $orderId",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Order Date: $orderDate",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Weight: $packageWeight",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Dimensions: $packageDimensions",
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Status: $deliveryStatus",
                fontSize = 16.sp,
                color = if (deliveryStatus == "In Transit") Color(0xFFFF8000) else Color.Green
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderScreenPreview() {
    OrderScreen(navController = rememberNavController()) // Preview with a navigation controller
}
