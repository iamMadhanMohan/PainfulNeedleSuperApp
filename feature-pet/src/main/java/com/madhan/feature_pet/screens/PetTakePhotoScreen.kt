package com.madhan.feature_pet.screens

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import coil3.compose.rememberAsyncImagePainter
import com.madhan.feature_pet.R
import java.io.File

@Composable
fun PetTakePhotoScreen() {
    val context = LocalContext.current
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    // Camera launcher
    var capturedImageUri by remember { mutableStateOf<Uri?>(null) }

    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            imageUri = capturedImageUri // Save the captured image URI
        }
    }

    // Gallery launcher
    val galleryLauncher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { imageUri = it }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* TODO: Navigate Back */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = Color(0xFFFF8C00),
                    modifier = Modifier.size(55.dp) // Adjusted Size
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Take a photo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* TODO: Show Help */ }) {
                Icon(
                    painter = painterResource(id = R.drawable.questionmark),
                    contentDescription = "Help",
                    tint = Color(0xFFFF8C00),
                    modifier = Modifier.size(28.dp) // Adjusted Size
                )
            }
            IconButton(onClick = { galleryLauncher.launch("image/*") }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_gallery),
                    contentDescription = "Gallery",
                    tint = Color(0xFFFF8C00),
                    modifier = Modifier.size(22.dp) // Adjusted Size
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Image Preview Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            if (imageUri != null) {
                Image(
                    painter = rememberAsyncImagePainter(imageUri),
                    contentDescription = "Selected Image",
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Icon(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = "Camera Placeholder",
                    modifier = Modifier.size(120.dp), // Adjusted size
                    tint = Color.Gray
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Capture Button
        Button(
            onClick = {
                val newUri = createImageFile(context) // Generate a file to store the image
                imageUri = newUri
                cameraLauncher.launch(imageUri!!)
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8C00)),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(56.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_camera),
                contentDescription = "Camera",
                tint = Color.White,
                modifier = Modifier.size(24.dp) // Adjusted icon size
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

// Function to create a temporary file for the image
fun createImageFile(context: Context): Uri {
    val file = File(context.getExternalFilesDir("Pictures"), "photo_${System.currentTimeMillis()}.jpg")
    return FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
}

@Preview
@Composable
fun PetTakePhotoScreenPreview() {
    PetTakePhotoScreen()
}