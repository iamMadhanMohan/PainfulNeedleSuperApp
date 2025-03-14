package com.madhan.adamsuperapp.ui.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.madhan.adamsuperapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignIn() {
    var email by remember { mutableStateOf("") }

    // Use a Box to set the background color for the entire screen
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary) // Set background to primary color
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Top Bar (Back Arrow - Placeholder)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = android.R.drawable.ic_menu_revert), // Replace with your back arrow icon
                    contentDescription = "Back",
                    tint = Color.White // Assuming white icons
                )
                Spacer(modifier = Modifier.weight(1f)) // Push icon to the start
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Logo
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background), // Replace with your logo resource
                contentDescription = "Pain Needle Logo",
                modifier = Modifier.size(100.dp) // Adjust size as needed
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Text(
                text = "Password recovery",
                fontSize = 24.sp,
                color = Color.White // Assuming white text
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Instruction Text
            Text(
                text = " Welcome to Pain Needle!",
                fontSize = 16.sp,
                color = Color.White, // Assuming white text
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(100.dp))

            // Email Input
            EmailInputField()

            Spacer(modifier = Modifier.height(8.dp))

            // Password Input
            OutlinedTextField(
                value = "",
                onValueChange = { },
                label = { Text("Password", color = Color.White) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    unfocusedIndicatorColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                    cursorColor = Color.White
                ),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email
                ),
                textStyle = LocalTextStyle.current.copy(
                    color = Color.White,
                    fontSize = 16.sp
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Send Button (Use secondary color)
            SignInButton {  }

            Spacer(modifier = Modifier.height(8.dp))

            // GitHub Login Button (Use secondary color)
            GitHubLoginButton(onClick = { /* Handle GitHub login */ } , )

            Spacer(modifier = Modifier.height(8.dp))

            GoogleLoginButton (onClick = { /* Handle GitHub login */   })

            // Create Account Link
            TextButton(onClick = { /* Handle create account */ }) {
                Text("No account? Create one!", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF00008B) // Dark blue background
@Composable
fun SignInPreview() {
    SignIn()
}



@Composable
fun SignInButton(onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Black), // Set border color to black
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = Color.White // Set text and icon color to white


        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Spacer(modifier = Modifier.width(8.dp))
            Text("Sign In")
        }
    }
}


@Composable
fun GitHubLoginButton(onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.Black), // Set border color to black
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color(0xFF24292F), // Set button background to black
            contentColor = Color.White // Set text and icon color to white
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.github), // Replace with your GitHub logo resource
                contentDescription = "GitHub Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Login with GitHub")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInputField() {
    // State to hold the email input
    var email by remember { mutableStateOf("") }

    OutlinedTextField(
        value = email,
        onValueChange = { newEmail ->
            email = newEmail
        },
        label = { Text("Email", color = Color.White) },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            cursorColor = Color.White
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        textStyle = LocalTextStyle.current.copy(
            color = Color.White,
            fontSize = 16.sp
        )
    )
}

@Composable
fun GoogleLoginButton(onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onSurface,
            containerColor = MaterialTheme.colorScheme.surface
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.google), // Replace with your GitHub logo resource
                contentDescription = "GitHub Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Login with GitHub")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GitHubLoginButtonPreview() {
    GitHubLoginButton(onClick = {
        // Placeholder for onClick action in preview
        println("GitHub login button clicked (preview)")
    })
}