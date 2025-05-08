package com.example.neuroparent.admin.presentation.events

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape




import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.width
import androidx.navigation.NavController
import com.example.neuroparent.core.navigation.NavigationManager
import com.example.neuroparent.shared.components.navigation.BottomNavItem
import com.example.neuroparent.shared.components.navigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateEventScreen(navController: NavController) {
    var title by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Cancel", fontSize = 16.sp, color = Color.Black)

            Text(
                text = "New Event",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(text = "Title")

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(text = "Location")
            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(text = "Date")
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.DateRange, contentDescription = "Calendar Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(text = "Time")
            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.AddCircle, contentDescription = "Clock Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(text = "Category")
            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                trailingIcon = {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Dropdown")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(text = "Description")
            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                shape = RoundedCornerShape(20),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Button(
                onClick = { /* Handle Add Event */ },
                modifier = Modifier
                    .width(160.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF87CAD5)
                )
            ) {
                Text("Add Event", fontSize = 20.sp)
            }
        }
    }
}