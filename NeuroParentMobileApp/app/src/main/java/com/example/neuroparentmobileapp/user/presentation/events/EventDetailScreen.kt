package com.example.neuroparentmobileapp.user.presentation.events

import androidx.compose.material3.CardDefaults


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

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
fun EventDetailScreen(navController: NavController) {
    val bottomNavItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Ideas,
        BottomNavItem.Calendar,
        BottomNavItem.Edit,
        BottomNavItem.Profile
    )

    val currentRoute = navController.currentDestination?.route ?: BottomNavItem.Calendar.route
    Scaffold(

        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                items = bottomNavItems,
                currentRoute = currentRoute
            )
        },
        topBar = {
            TopAppBar(
                title = { Row {
                    Text("Supporting Your\nNeurodivergent Child", fontSize = 25.sp)
                    Spacer(modifier = Modifier.width(25.dp)) // ✅ Valid inside a Row
                } },

                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack()  }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerpadding ->
        Column(
            modifier = Modifier
                .padding(innerpadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            EventDetailsCard()
            Spacer(modifier = Modifier.height(16.dp))
            Text("Description", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit. Sed Do Eiusmod Tempor Incididunt Ut Labore Et Dolore Magna Aliqua.\n\n" +
                        "Ut Enim Ad Minim Veniam, Quis Nostrud Exercitation Ullamco\n\n" +
                        "Laboris Nisi Ut Aliquip Ex Ea Commodo Consequat.",
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* Handle register */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB3E5FC)) // Light blue
            ) {
                Text("Register", color = Color.White)
            }
        }
    }
}

@Composable
fun EventDetailsCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            EventDetailRow("Date", "April 20, 2025")
            Spacer(modifier = Modifier.height(8.dp))
            EventDetailRow("Time", "7:00 pm")
            Spacer(modifier = Modifier.height(8.dp))
            EventDetailRow("Location", "Room H-12,\nHilton Hotel,\nAddis Ababa,\nEthiopia")
        }
    }
}

@Composable
fun EventDetailRow(label: String, value: String) {
    Row {
        Text(label, fontWeight = FontWeight.Bold, modifier = Modifier.width(80.dp))
        Text(value)
    }
}

