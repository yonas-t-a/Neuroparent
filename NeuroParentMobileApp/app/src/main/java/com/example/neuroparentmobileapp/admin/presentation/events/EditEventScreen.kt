package com.example.neuroparentmobileapp.admin.presentation.events


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
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
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.navigation.NavController
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavItem
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavigationBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditEventScreen(navController: NavController) {
    var title by remember { mutableStateOf("Social skills workshop") }
    var location by remember { mutableStateOf("Addis Ababa, Ethiopia") }
    var date by remember { mutableStateOf("April 20, 2025") }
    var time by remember { mutableStateOf("7:00 pm") }
    var category by remember { mutableStateOf("ADHD") }
    var description by remember {
        mutableStateOf(
            "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Sed Do Eiusmod Tempor Incididunt Ut Labore Et Dolore Magna Aliqua."
        )
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
        topBar = {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .verticalScroll(scrollState)
            ) {
                TextButton(
                    onClick = { /* Handle cancel */ },

                    ) {
                    Text(text = "Cancel", color = Color.Black, modifier = Modifier.padding(start = 5.dp))
                }
                Text(
                    text = "New Event",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 30.sp

                )
            }


        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = bottomNavItems,
                currentRoute = currentRoute
            )
        }
    ) { innerPadding ->
        val scrollState = rememberScrollState()
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Title"
            )
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(
                text = "Location"
            )

            OutlinedTextField(
                value = location,
                onValueChange = { location = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )

            Text(
                text = "Date"
            )
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                trailingIcon = {
                    Icon(Icons.Filled.DateRange, contentDescription = "Calendar Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(
                text = "Time"
            )

            OutlinedTextField(
                value = time,
                onValueChange = { time = it },
                trailingIcon = {
                    Icon(Icons.Filled.AddCircle, contentDescription = "Clock Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )

            Text(
                text = "Category"
            )

            OutlinedTextField(
                value = category,
                onValueChange = { category = it },
                trailingIcon = {
                    Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Dropdown Icon")
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20)
            )
            Text(
                text = "Description"
            )

            OutlinedTextField(
                value = description,
                onValueChange = { description = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                shape = RoundedCornerShape(10)
            )
            Button(
                onClick = { /* Handle edit */ },
                modifier = Modifier
                    .padding(16.dp)

                    .width(160.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(50),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE57373))
            ) {
                Text(text = "Edit Event", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}