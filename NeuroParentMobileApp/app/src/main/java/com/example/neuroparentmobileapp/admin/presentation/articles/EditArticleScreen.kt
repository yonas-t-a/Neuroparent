package com.example.neuroparentmobileapp.admin.presentation.articles

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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavItem
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavigationBar


@Composable
fun EditArticleScreen(
//    onCancel: () -> Unit,
//    onPreview: () -> Unit,
//    onAddArticle: (title: String, content: String, imageUri: Uri?) -> Unit,
    navController : NavController
) {
    var title by remember { mutableStateOf("") }
    var content by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }

    val bottomNavItems = listOf(
        BottomNavItem.AdminHome,
        BottomNavItem.AdminIdeas,
        BottomNavItem.AdminCalendar,
        BottomNavItem.AdminEdit,
        BottomNavItem.AdminProfile,
        BottomNavItem.Add
    )

    val currentRoute = navController.currentDestination?.route ?: BottomNavItem.Calendar.route

    Scaffold(bottomBar = {
        BottomNavigationBar(
            navController = navController,
            items = bottomNavItems,
            currentRoute = currentRoute
        )
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(paddingValues)
        ) {
            Text("Cancel", modifier = Modifier.clickable { /*onCancel() */})
            // Top Row: Cancel & Preview
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("New Article", modifier = Modifier.padding(start = 0.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                Text("Preview", color = Color.Red, modifier = Modifier.clickable { /*onPreview() */})
            }
            Text(text = "Title")

            // Title Input
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("creating routines") },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = Color(0xFFEFF6FC),
                    unfocusedContainerColor = Color(0xFFEFF6FC),
                    focusedContainerColor = Color(0xFFEFF6FC)
                )
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Image Upload (Mocked with Button for simplicity)
            val imageUri = remember { mutableStateOf<Uri?>(null) }

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.GetContent()
            ) { uri: Uri? ->
                imageUri.value = uri
            }
            var selectedImageName by remember { mutableStateOf<String?>(null) }

            ImagePickerField(
                selectedImageName = selectedImageName,
                onPickImageClick = {
                    launcher.launch("image/*")
                }
            )


            Spacer(modifier = Modifier.height(12.dp))

            // Content Input
            Text(text = "content")
            OutlinedTextField(
                value = content,
                onValueChange = { content = it },
                label = { Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. \n" +
                        "\n" +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco \u2028\u2028laboris nisi ut aliquip ex ea commodo consequat. \n") },
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

            // Add Article Button
            Button(
                onClick = { /*onAddArticle(title, content, imageUri)*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFA1DCEB),
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(24.dp)
            ) {
                Text("Edit Article")
            }
        }
    }

    }


@Composable
fun ImagePickerField(
    selectedImageName: String?,
    onPickImageClick: () -> Unit
) {
    OutlinedTextField(
        value = selectedImageName ?: "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onPickImageClick() }, // Makes the whole field clickable
        label = { Text("Add image") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Add, // or use any upload icon
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