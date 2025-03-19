package com.madhan.feature_pet.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.madhan.core.ui.components.CommonCalendar
import com.madhan.core.ui.components.CustomButton
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChooseDateScreen(navController: NavHostController, onDateSelected: (String, String) -> Unit) {
    var startDate by remember { mutableStateOf<LocalDate?>(null) }
    var endDate by remember { mutableStateOf<LocalDate?>(null) }

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
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back", tint = Color(0xFFFF8C00))
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Choose date", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Use CommonCalendar
        CommonCalendar(
            startDate = startDate,
            endDate = endDate,
            onDateSelected = { selectedDate ->
                if (startDate == null || (startDate != null && endDate != null)) {
                    startDate = selectedDate
                    endDate = null
                } else if (selectedDate > startDate!!) {
                    endDate = selectedDate
                }
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        // Next Button
        CustomButton(
            onClick = {
                if (startDate != null && endDate != null) {
                    onDateSelected(startDate.toString(), endDate.toString())
                    navController.navigate("pet_care_list")
                }
            },
            buttonText = "Next"
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ChooseDateScreenPreview() {
    val navController = rememberNavController()
    ChooseDateScreen(navController) { _, _ -> }
}
