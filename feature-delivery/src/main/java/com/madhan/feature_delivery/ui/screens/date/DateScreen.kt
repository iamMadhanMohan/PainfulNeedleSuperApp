package com.madhan.feature_delivery.ui.screens.date

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChooseDateScreen(navController: NavController) {
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CustomBackButton { navController.navigate("delivery_men") }
            Spacer(modifier = Modifier.weight(0.5f))
            Text(text = "Choose date", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Selected Date
        Column(horizontalAlignment = Alignment.Start) {
            Text(text = "Date", fontSize = 14.sp, color = Color(0xFFFF8C00))
            Text(
                text = selectedDate?.toString() ?: "Select Date",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Calendar Component
        CalendarView(selectedDate = selectedDate, onDateSelected = { selected ->
            selectedDate = selected
        })

        Spacer(modifier = Modifier.height(300.dp))
        Row(horizontalArrangement = Arrangement.Absolute.Center,
            modifier = Modifier.fillMaxWidth()) {

            // Next Button
            BottomOrangeButton("Next") { navController.navigate("delivery_men") }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalendarView(selectedDate: LocalDate?, onDateSelected: (LocalDate) -> Unit) {
    var currentMonth by remember { mutableStateOf(LocalDate.now()) }
    val firstDayOfMonth = currentMonth.withDayOfMonth(1)
    val daysInMonth = currentMonth.lengthOfMonth()
    val startDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7 // Adjust to match Sunday index 0

    Column(modifier = Modifier.fillMaxWidth()) {
        // Month Navigation
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            IconButton(onClick = {
                currentMonth = currentMonth.minusMonths(1) // Handle Previous Month
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.go_left), // Replace with your backward arrow drawable
                    contentDescription = "Previous Month",
                    modifier = Modifier.size(22.dp) // Set the size of the backward arrow
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = currentMonth.month.toString(), fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.width(16.dp))
            IconButton(onClick = {
                currentMonth = currentMonth.plusMonths(1) // Handle Next Month
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.go_right), // Replace with your forward arrow drawable
                    contentDescription = "Next Month",
                    modifier = Modifier.size(24.dp) // Set the size of the forward arrow
                )
            }
        }

        // Days of the Week Header
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            listOf("S", "M", "T", "W", "T", "F", "S").forEach {
                Text(text = it, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Display Dates with Proper Alignment
        Column {
            var currentDay = 1 - startDayOfWeek // Start from the correct weekday

            while (currentDay <= daysInMonth) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (day in 0 until 7) { // Week has 7 days
                        val date = if (currentDay in 1..daysInMonth) {
                            LocalDate.of(currentMonth.year, currentMonth.month, currentDay)
                        } else {
                            null
                        }

                        val isSelected = date != null && date == selectedDate

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .background(
                                    if (isSelected) Color(0xFF4CAF50) else Color.Transparent,
                                    RoundedCornerShape(18.dp)
                                )
                                .clickable { date?.let { onDateSelected(it) } },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (currentDay in 1..daysInMonth) currentDay.toString() else "",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isSelected) Color.White else Color.Black
                            )
                        }

                        currentDay++ // Move to the next day
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun ChooseDateScreenPreview() {
    val navController = rememberNavController()
    ChooseDateScreen(navController)
}
