package com.madhan.adamsuperapp.ui.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.madhan.adamsuperapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordRecoveryScreen() {
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

        Spacer(modifier = Modifier.height(24.dp))

        // Phone Number Input
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Email", color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ),
            textStyle = LocalTextStyle.current.copy(color = Color.White) // Correct way to set text color
        )

        Spacer(modifier = Modifier.height(8.dp))



        Spacer(modifier = Modifier.height(8.dp))

        // Email Input
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Password", color = Color.White) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.White,
                unfocusedBorderColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White
            ),
            textStyle = LocalTextStyle.current.copy(color = Color.White) // Correct way to set text color
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Send Button
        SignInButton() {}

        Spacer(modifier = Modifier.height(16.dp))

        GitHubLoginButton (){
        }
        Spacer(modifier = Modifier.height(16.dp))
        GoogleLoginButton (){}

        // Create Account Link
        TextButton(onClick = { }) {
            Text("No account? Create one!", color = Color.White)
        }
    }
}

@Composable
fun SignInButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp) // Same padding as GitHub button
    ) {
        Text("Sign In")
    }
}


@Composable
fun GitHubLoginButton(onClick: () -> Unit) {
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
                painter = painterResource(id = R.drawable.github), // Replace with your GitHub logo resource
                contentDescription = "GitHub Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Login with GitHub")
        }
    }
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
    PasswordRecoveryScreen()
}