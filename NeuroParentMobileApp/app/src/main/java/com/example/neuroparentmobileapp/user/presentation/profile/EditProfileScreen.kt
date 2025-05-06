package com.example.neuroparentmobileapp.user.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreenEdit(onBack: () -> Unit) {
    var name by remember { mutableStateOf("Abebe Girma Thomas") }
    var newPasswoed by remember { mutableStateOf("ThisIstheOldPassword=123") }
    var oldPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally
//        verticalArrangement = Arrangement.Center
    ) {
        // Profile Icon
        Box(
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
//                .border(width = 0.1.dp, color = Color.Black)
                .background(Color.Black),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "Profile Icon",
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // App Name
        Text(
            text = "NeuroParent",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Name Field
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            enabled = true,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFE8F0FE), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
        )

        Spacer(modifier = Modifier.height(12.dp))

        // New Password Field
        OutlinedTextField(
            value = newPasswoed,
            onValueChange = { newPasswoed = it },
            enabled = true,
            label = { Text("Edit Password") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFE8F0FE), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
        )

        Spacer(modifier = Modifier.height(80.dp))

        // Old Password Field
        OutlinedTextField(
            value = oldPassword,
            onValueChange = { oldPassword = it },
            enabled = true,
            label = { Text("Verify with Previous Password") },
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .background(Color(0xFFE8F0FE), RoundedCornerShape(8.dp)),
            shape = RoundedCornerShape(8.dp),
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Edit Profile Button
        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE89A9A)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .height(45.dp)
        ) {
            Text(text = "Save Changes")
        }
    }
}