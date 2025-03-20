package com.madhan.adamsuperapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.madhan.adamsuperapp.R
import com.madhan.adamsuperapp.auth.SigninWithEmailAndPassword
import com.madhan.adamsuperapp.navigation.Screen
import com.madhan.adamsuperapp.ui.theme.PrimaryColor
import com.madhan.core.ui.components.PrimaryButton
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    navController: NavController,
    onNavigateToSignIn: () -> Unit
) {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }
    val context = LocalContext.current

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Dummy list of already signed-up emails (for demonstration)
    val signedUpEmails = listOf("john@example.com", "mike@domain.com", "jane@company.com")

    fun isValidEmail(email: String): Boolean {
        return Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$").matches(email)
    }

    fun isValidPassword(password: String): Boolean {
        return Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=!]).{6,}$").matches(password)
    }

    fun doPasswordsMatch(password: String, confirmPassword: String): Boolean {
        return password == confirmPassword
    }

    //Handle Sign up
    fun handleSignUp() {
        when {
            userName.isEmpty() -> coroutineScope.launch {
                snackbarHostState.showSnackbar("Username cannot be empty")
            }
            !isValidEmail(email) -> coroutineScope.launch {
                snackbarHostState.showSnackbar("Invalid email format")
            }
            !isValidPassword(password) -> coroutineScope.launch {
                snackbarHostState.showSnackbar("Password must have at least 6 characters, 1 capital, 1 number, and 1 special character")
            }
            !doPasswordsMatch(password, confirmPassword) -> coroutineScope.launch {
                snackbarHostState.showSnackbar("Passwords do not match")
            }
            signedUpEmails.contains(email) -> {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Email already exists! Redirecting to Sign In...")
                }
                navController.navigate(Screen.SignIn.route)
            }
            else -> {
                try {
                    SigninWithEmailAndPassword.signUp(
                        email, password,
                        onResult = {
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar("Account Created Successfully")
                            }
                            navController.navigate(Screen.SignIn.route) {
                                popUpTo(Screen.SignUp.route) { inclusive = true }
                            }
                        }
                    )
                } catch (e: Exception) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar("Error: ${e.message}")
                    }
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) } // Attach SnackbarHost
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()
                    .padding(16.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(
                        text = "Signup",
                        fontSize = 24.sp,
                        color = Color(0xFFFF8000),
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Image(
                        painter = painterResource(id = R.drawable.signuplogo),
                        contentDescription = "Signup Image",
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .aspectRatio(1f)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // User Name Field
                    OutlinedTextField(
                        value = userName,
                        onValueChange = { userName = it },
                        label = { Text("User Name") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged { isFocused = it.isFocused },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    // Email Field
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email Address") },
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged { isFocused = it.isFocused },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = Color.Gray
                        )
                    )
                    Spacer(modifier = Modifier.height(12.dp))

                    // Password Field
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged { isFocused = it.isFocused },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Confirm Password Field
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        label = { Text("Confirm Password") },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged { isFocused = it.isFocused },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = PrimaryColor,
                            unfocusedBorderColor = Color.Gray
                        )
                    )

                    Spacer(modifier = Modifier.height(34.dp))

                    // Create Account Button
                    PrimaryButton(
                        text = "Create Account",
                        onClick = {
                            handleSignUp()
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Sign In Text
                    Row(horizontalArrangement = Arrangement.Center) {
                        Text(
                            modifier = Modifier.clickable {
                                navController.navigate(Screen.SignIn.route){
                                    popUpTo(Screen.SignUp.route){inclusive=true}
                                }
                            },
                            text = AnnotatedString("Already have an account? Sign in"),
                            style = TextStyle(color = Color(0xFFFF8000), fontSize = 14.sp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen(
        navController = rememberNavController(),
        onNavigateToSignIn = {} // Provide a default empty function
    )
}