package com.example.neuroparentmobileapp.auth.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.neuroparentmobileapp.R
import androidx. navigation. NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.neuroparentmobileapp.auth.data.repository.TokenManager
import com.example.neuroparentmobileapp.auth.domain.usecase.LoginUseCase

@Composable
fun Login(
    navController: NavController,
    loginUseCase: LoginUseCase,
    tokenManager: TokenManager,
    onSignInSuccess: () -> Unit
) {
    val viewModel: LogInViewModel = viewModel(
        factory = LogInViewModelFactory(loginUseCase, tokenManager)
    )
    val email = viewModel.email.collectAsState().value
    val password = viewModel.password.collectAsState().value
    val loading = viewModel.loading.collectAsState().value
    val error = viewModel.error.collectAsState().value

//    // Navigate on successful login
//    LaunchedEffect(uiState.token, uiState.role) {
//        if (uiState.token != null && uiState.role != null) {
//            if (uiState.role.equals("user", ignoreCase = true)) {
//                navController.navigate("HomeScreen") {
//                    popUpTo("login") { inclusive = true }
//                }
//            } else {
//                navController.navigate("AdminHomeScreen") {
//                    popUpTo("login") { inclusive = true }
//                }
//            }
//        }
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.t8),
            contentDescription = "My image description",
            modifier = Modifier.size(150.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "NeuroParent",
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp
            ),
            modifier = Modifier.padding(bottom = 32.dp),
            color = Color.Black
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
//            horizontalA = Arrangement.SpaceEvenly
        ) {

            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = email,
                onValueChange = viewModel::onEmailChange,
                label = { Text("Email") },
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = password,
                onValueChange = viewModel::onPasswordChange,
                label = { Text("Password") },
                shape = RoundedCornerShape(16.dp),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = { viewModel.LogIn(onSignInSuccess) },
                enabled = !loading,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 80.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF93ADD4),
                    contentColor = Color.White
                )
            ) {
                Text(if (loading) "Signing In..." else "Sign In", fontSize = 20.sp)
            }
            error?.let {
                Spacer(modifier = Modifier.height(8.dp))
                Text(it, color = MaterialTheme.colorScheme.error)
            }
            Spacer(modifier = Modifier.height(16.dp))
//        if (uiState.error != null) {
//            Text(
//                text = uiState.error ?: "",
//                color = Color.Red,
//                modifier = Modifier.padding(bottom = 8.dp)
//            )
//        }
            TextButton(
                onClick = { navController.navigate("signup") },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = AnnotatedString.Builder().apply {
                        withStyle(style = SpanStyle(color = Color.Black)) {
                            append("New to Neuroparent?")
                        }
                        withStyle(style = SpanStyle(color = Color.Blue)) {
                            append("Sign up")
                        }
                    }.toAnnotatedString(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}