package com.madhan.feature_uber.Screens.ui


import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.madhan.feature_uber.R



@Composable
fun PermissionScreen(    onBackClick: () -> Unit , onLetsGoClick: () -> Unit
) {

    val orange = Color(0xFFFF7D1E)
    val lightGray = Color(0xFFF5F5F5)
    val mediumGray = Color(0xFFAAAAAA)
    val darkGray = Color(0xFF9E9E9E)
    val blue = Color(0xFF2196F3)
    val green = Color(0xFF4CAF50)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Navigation (Simple Back Arrow)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            IconButton(onClick = { onBackClick() }) {
                Icon(painterResource(id = android.R.drawable.ic_menu_revert), contentDescription = "Back")
            }
        }


        Spacer(modifier = Modifier.height(70.dp))

        // Illustration
        Image(
            painter = painterResource(id = R.drawable.img), // Replace with your image resource
            contentDescription = "Transport Illustration",
            modifier = Modifier.size(height = 230.dp, width = 307.dp)
        )

        Spacer(modifier = Modifier.height(90.dp))

        //     Title
        Row(
            modifier = Modifier
                .height(42.dp) // Set the height of the container
                .width(335.dp), // Set the width of the container
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Enable Geolocation",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .height(75.dp) // Set the height of the container
                .width(335.dp), // Set the width of the container
            horizontalArrangement = Arrangement.Center
        ) {
            // Description
            Text(
                text = "Please give access to your phone Location so that you have a more seamless experience ",
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(150.dp)) // Push button to bottom with 1f


        val context = LocalContext.current
        val locationPermissionLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission()
        ) { isGranted ->
            if (isGranted) {
                // Permission granted, proceed with location-related logic
                onLetsGoClick()
            } else {
                // Permission denied, show a message or handle accordingly
                Toast.makeText(context, "Location permission is required for this feature", Toast.LENGTH_SHORT).show()
            }
        }
        // Button
        Button(
            onClick = {
                // Check if permission is already granted
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    // Permission already granted, proceed
                    onLetsGoClick()
                } else {
                    // Request permission
                    locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = orange),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Order",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@RequiresApi(Build.VERSION_CODES.N)
fun RequestPermissions(): () -> Unit {
    val context = LocalContext.current

    // State to track if permissions are granted
    var hasFineLocationPermission by remember { mutableStateOf(false) }
    var hasCoarseLocationPermission by remember { mutableStateOf(false) }

    // Launcher for requesting multiple permissions
    val locationPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        hasFineLocationPermission = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
        hasCoarseLocationPermission = permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true
    }

    // Check if permissions are already granted when the composable is first launched
    LaunchedEffect(Unit) {
        hasFineLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        hasCoarseLocationPermission = ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    // Return a function to request permissions
    return {
        locationPermissionLauncher.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RequestPermissionsPreview() {
    MaterialTheme {
        RequestPermissions()
    }
}



@Preview(showBackground = true)
@Composable
fun PermissionScreenPreview() {
    MaterialTheme {
        PermissionScreen(
            onBackClick = TODO(),
            onLetsGoClick = TODO()
        )
    }
}