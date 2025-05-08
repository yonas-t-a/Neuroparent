package com.example.neuroparentmobileapp.admin.presentation.events

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.navigation.NavController
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavItem
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminEventsScreen(navController: NavController) {
    val events = remember {
        mutableStateListOf(
            Event(
                date = "Apr 20",
                title = "Social skills workshop",
                location = "Addis Ababa, Ethiopia",
                time = "7:00 pm"
            ),
            Event(
                date = "May 2",
                title = "Supporting Your Neurodivergent Child",
                location = "Online",
                time = "7:00 pm"
            )
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
            TopAppBar(
                title = { Text("Events",
                    fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back",  modifier = Modifier.size(30.dp))
                    }
                }
            )
        },
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
                .padding(4.dp)
        ) {

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                items(events) { event ->
                    EventCard(event)
                }
            }
        }
    }
}

@Composable
fun EventCard(event: Event) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(400.dp)
            .padding(vertical = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF9F9F9), RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(
                    modifier = Modifier
                        .background(Color(0xFFE0E0E0), RoundedCornerShape(8.dp))
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = event.date.split(" ")[0], // Month
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = event.date.split(" ")[1], // Day
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = event.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = event.location,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = event.time,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp) // Optional padding around the buttons
            ) {
                Column(
                    modifier = Modifier
                        .align(Alignment.TopEnd), // Aligns both buttons to the top right
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        onClick = { /* Edit event */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDB6B6B)
                        ),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .width(100.dp)
                    ) {
                        Text(text = "Edit")
                    }

                    Spacer(modifier = Modifier.height(2.dp))

                    Button(
                        onClick = { /* Cancel event */ },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDB6B6B)
                        ),
                        shape = RoundedCornerShape(50),
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(text = "Cancel Event")
                    }
                }
            }

        }
    }
}

data class Event(
    val date: String,
    val title: String,
    val location: String,
    val time: String
)
