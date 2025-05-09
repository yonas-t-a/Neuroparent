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

@Composable
fun Login(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val roundedShape = RoundedCornerShape(12.dp)
    val backgroundColor = Color(0xFFF7F6F4)
    var selectedUserType by remember { mutableStateOf("Admin") }

    // Navigate on successful login
    LaunchedEffect(uiState.token, uiState.role) {
        if (uiState.token != null && uiState.role != null) {
            if (uiState.role.equals("user", ignoreCase = true)) {
                navController.navigate("HomeScreen") {
                    popUpTo("login") { inclusive = true }
                }
            } else {
                navController.navigate("AdminHomeScreen") {
                    popUpTo("login") { inclusive = true }
                }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            FilterChip(
                selected = selectedUserType == "Admin",
                onClick = { selectedUserType = "Admin" },
                label = { Text("Admin") },
                modifier = Modifier.weight(1f),
                shape = roundedShape,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (selectedUserType == "Admin") {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        Color(0xFFD9D9D9)
                    }
                )
            )
            Spacer(modifier = Modifier.width(16.dp))
            FilterChip(
                selected = selectedUserType == "User",
                onClick = { selectedUserType = "User" },
                label = { Text("User") },
                modifier = Modifier.weight(1f),
                shape = roundedShape,
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = if (selectedUserType == "User") {
                        MaterialTheme.colorScheme.primaryContainer
                    } else {
                        Color(0xFFD9D9D9)
                    }
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = uiState.email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") },
            shape = roundedShape,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = uiState.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") },
            shape = roundedShape,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = { viewModel.login() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 80.dp),
            shape = roundedShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF93ADD4),
                contentColor = Color.White
            )
        ) {
            Text("Log in", fontSize = 20.sp)
        }
        Spacer(modifier = Modifier.height(16.dp))
        if (uiState.error != null) {
            Text(
                text = uiState.error ?: "",
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
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