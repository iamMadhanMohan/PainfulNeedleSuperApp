package com.madhan.adamsuperapp.ui.screens


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
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
import com.madhan.adamsuperapp.ui.theme.PrimaryColor
import kotlinx.coroutines.launch

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
    val context = LocalContext.current
    val activity = LocalContext.current.findActivity()
    var passwordVisible by remember { mutableStateOf(false) }

    val viewModel: SigninWithGoogleViewModel = hiltViewModel()
    val loginState by viewModel.loginState.collectAsState()

    // Snackbar State
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    // Observe login state changes
    LaunchedEffect(loginState) {
        when (loginState) {
            is UiStatus.SUCCESS -> {
                val user = (loginState as UiStatus.SUCCESS)
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Welcome, ${user.message.displayName} to Super App")
                }
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.SignIn.route) { inclusive = true }
                }
            }
            is UiStatus.ERROR -> {
                val errorMessage = (loginState as UiStatus.ERROR).error
                coroutineScope.launch {
                    snackbarHostState.showSnackbar("Login failed: $errorMessage")
                }
            }
            else -> {}
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { /* Empty title */ },
                navigationIcon = {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) } // Attach SnackbarHost
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
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Pain Needle Logo",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(16.dp))
                        .border(3.dp, Color.LightGray, RoundedCornerShape(16.dp))
                        .background(Color.White)
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Sign In", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Welcome to Pain Needle!", fontSize = 16.sp, textAlign = TextAlign.Center)
                    Spacer(modifier = Modifier.height(24.dp))

                    OutlinedTextField(
                        value = email,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        visualTransformation = if (passwordVisible) VisualTransformation.None
                        else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
                        label = { Text("Password") },
                        modifier = Modifier.fillMaxWidth(),
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = {
                            LogIn(email, password) { user ->
                                coroutineScope.launch {
                                    if (user != null) {
                                        snackbarHostState.showSnackbar("Login Successful")
                                        navController.navigate(Screen.Home.route) {
                                            popUpTo(Screen.SignIn.route) { inclusive = true }
                                        }
                                    } else {
                                        snackbarHostState.showSnackbar("Login failed, Check credentials and try again!")
                                    }
                                }
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor, contentColor = Color.White)
                    ) {
                        Text("Sign In")
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    GitHubLoginButton(
                        onClick = {
                            SigninWithGithub.signIn(activity = activity!!) {
                                navController.navigate("home")
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    GoogleLoginButton(
                        onClick = { viewModel.authenticate(context = context) }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    TextButton(
                        onClick = {
                            navController.navigate(Screen.SignUp.route){
                                popUpTo(Screen.SignIn.route){inclusive=true}
                            }
                        }
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