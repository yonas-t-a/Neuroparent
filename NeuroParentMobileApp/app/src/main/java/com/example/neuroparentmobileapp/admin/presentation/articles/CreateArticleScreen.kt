package com.example.neuroparent.admin.presentation.articles


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.neuroparent.shared.components.navigation.BottomNavItem
import com.example.neuroparent.shared.components.navigation.BottomNavigationBar

@Composable
fun ImagePickersField(
    selectedImageName: String?,
    onPickImageClick: () -> Unit
) {
    OutlinedTextField(
        value = selectedImageName ?: "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPickImageClick() },
        label = { Text("Add image") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Upload",
                modifier = Modifier.clickable { onPickImageClick() }
            )
        },
        readOnly = true,
        enabled = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFEFF6FC),
            unfocusedContainerColor = Color(0xFFEFF6FC),
            disabledContainerColor = Color(0xFFEFF6FC),
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
            disabledIndicatorColor = Color.Gray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            disabledTextColor = Color.Black,
            focusedLabelColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
            disabledLabelColor = Color.Gray,
            focusedLeadingIconColor = Color.Gray,
            unfocusedLeadingIconColor = Color.Gray,
            disabledLeadingIconColor = Color.Gray
        )
    )
}


@Composable
fun CreateArticleScreen(navController : NavController) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var selectedImageName by remember { mutableStateOf<String?>(null) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
        selectedImageName = uri?.lastPathSegment
    }

    val bottomNavItems = listOf(
        BottomNavItem.AdminHome,
        BottomNavItem.AdminIdeas,
        BottomNavItem.AdminCalendar,
        BottomNavItem.AdminEdit,
        BottomNavItem.AdminProfile,
        BottomNavItem.Add
    )

    val currentRoute = navController.currentDestination?.route ?: BottomNavItem.Calendar.route

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = bottomNavItems,
                currentRoute = currentRoute
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text("Cancel", modifier = Modifier.clickable { /*onCancel()*/ })
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "New Article",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Text("Preview", color = Color.Red, modifier = Modifier.clickable { /*onPreview()*/ })
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color(0xFFEFF6FC),
                    unfocusedContainerColor = Color(0xFFEFF6FC),
                    focusedContainerColor = Color(0xFFEFF6FC)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            ImagePickersField(
                selectedImageName = selectedImageName,
                onPickImageClick = {
                    launcher.launch("image/*")
                }
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Content") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color(0xFFEFF6FC),
                    unfocusedContainerColor = Color(0xFFEFF6FC),
                    focusedContainerColor = Color(0xFFEFF6FC)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* onAddArticle(title, content, imageUri) */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA1DCEB),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Add Article")
            }
        }
    }
}