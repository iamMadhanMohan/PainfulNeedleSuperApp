package com.madhan.adamsuperapp.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.adamsuperapp.R
import com.madhan.adamsuperapp.auth.SigninWithEmailAndPassword.Companion.LogIn
import com.madhan.adamsuperapp.auth.SigninWithGithub
import com.madhan.adamsuperapp.auth.findActivity
import com.madhan.adamsuperapp.auth.google.SigninWithGoogleViewModel
import com.madhan.adamsuperapp.navigation.Screen
import com.madhan.adamsuperapp.utils.UiStatus


val orange = Color(0xFFFF7D1E)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(
    navController: NavController,
    onSignIn: () -> Unit = {},
    onCreateAccount: () -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val activity = LocalContext.current.findActivity()

    // Get the ViewModel using hiltViewModel()
    val viewModel: SigninWithGoogleViewModel = hiltViewModel()

    // Observe the login state
    val loginState by viewModel.loginState.collectAsState()
   // val logoutState by viewModel.logoutState.collectAsState()

    //context
    val context = LocalContext.current

    // UI elements based on login state
    when (loginState) {
        is UiStatus.LOADING -> {
            // Show loading spinner while signing in
            CircularProgressIndicator()
        }
        is UiStatus.SUCCESS -> {
            // Navigate to next screen on success
            val user = (loginState as UiStatus.SUCCESS)
            Toast.makeText(context, "Welcome, ${user.message.displayName} to Super App", Toast.LENGTH_LONG).show()
            navController.navigate(Screen.Home.route)

        }
        is UiStatus.ERROR -> {
            // Handle login error
            val errorMessage = (loginState as UiStatus.ERROR).error
            Toast.makeText(context, "Login failed: $errorMessage", Toast.LENGTH_LONG).show()

        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Empty title to match the SetPickup screen */ },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Logo
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Pain Needle Logo",
                    modifier = Modifier.size(100.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Sign In Form in a card-like container similar to SetPickup bottom sheet
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .border(3.dp, Color.LightGray, RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Sign In",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Welcome to Pain Needle!",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Email Input - Styled like the search field in SetPickup
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(16.dp))
                    // Password Input
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Sign In Button - Using the same color as the FloatingActionButton in SetPickup
                    Button(
                        onClick = {
                            LogIn(email, password) { user ->
                                if (user != null) {
                                    Log.d("Auth", "Sign-in successful for $email")
                                    navController.navigate(Screen.Home.route) // Navigate to Home or Dashboard
                                } else {
                                    Log.e("Auth", "Sign-in failed")
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = orange,
                            contentColor = Color.White
                        )
                    ) {
                        Text("Sign In")
                    }


                    Spacer(modifier = Modifier.height(16.dp))

                    // Social Login Buttons with consistent styling
                    GitHubLoginButton(
                        onClick = {
                            SigninWithGithub.signIn(
                                activity = activity!!,
                                onSuccess = {
                                    navController.navigate("home")
                                }
                            )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    GoogleLoginButton(
                        onClick = {
                            // Trigger Google sign-in
                            viewModel.authenticate(context = context )
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Create Account Link
                    TextButton(
                        onClick = { navController.navigate(Screen.SignUp.route) },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text("No account? Create one!")
                    }
                }
            }
        }
    }
}

@Composable
fun GitHubLoginButton(onClick: () -> Unit = {}) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
            containerColor = Color.White
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.github),
                contentDescription = "GitHub Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Login with GitHub")
        }
    }
}

@Composable
fun GoogleLoginButton(onClick: () -> Unit = {}) {
    OutlinedButton(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(1.dp, Color.LightGray),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black,
            containerColor = Color.White
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Logo",
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("Login with Google")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInScreenPreview() {
    SignInScreen(rememberNavController())
}