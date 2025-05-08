package com.example.neuroparentmobileapp.admin.presentation.events


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.navigation.NavController
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavItem
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavigationBar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminAllEvent(navController: NavController) {
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
        topBar = { TopBar() },
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
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            SearchBar()
            Spacer(modifier = Modifier.height(16.dp))
            CategoryTabs()
            Spacer(modifier = Modifier.height(16.dp))
            EventList()
        }
    }
}

@Composable
fun TopBar() {
    Text(
        text = "Events",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    var searchQuery by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text("Search events") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
        trailingIcon = { Icon(Icons.Default.DateRange, contentDescription = "Calendar") },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(16.dp))
    )
}


@Composable
fun CategoryTabs() {
    val categories = listOf("Unregistered", "Registered")
    var selectedCategory by remember { mutableIntStateOf(0) }
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        categories.forEachIndexed { index, category ->
            TextButton(
                onClick = { selectedCategory = index },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (selectedCategory == index) Color(0xFFD6EAF8) else Color.Transparent
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = category)
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    val subCategories = listOf("All", "ADHD", "Autism", "Dyslexia")
    var selectedSubCategory by remember { mutableIntStateOf(0) }
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.fillMaxWidth()) {
        subCategories.forEachIndexed { index, sub ->
            TextButton(
                onClick = { selectedSubCategory = index },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (selectedSubCategory == index) Color(0xFFD6EAF8) else Color.Transparent
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = sub, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun EventList() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        EventCard("Apr 20", "Social skills workshop", "Addis Ababa, Ethiopia", "7:00 pm", "Register")
        EventCard("May 2", "Supporting Your Neurodivergent Child", "Online", "7:00 pm", "Register")
        EventCard("May 10", "Autism Parent Meetup", "Dire Dawa, Ethiopia", "7:00 pm", "Registered")
    }
}

@Composable
fun EventCard(date: String, title: String, location: String, time: String, status: String) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                DateBadge(date)
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Text(text = location, color = Color.Gray, fontSize = 14.sp)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = time, fontSize = 14.sp, color = Color.Gray)
                StatusButton(status)
            }
        }
    }
}

@Composable
fun DateBadge(date: String) {
    val parts = date.split(" ")
    Column(
        modifier = Modifier
            .background(color = Color(0xFFE8E8E8), shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = parts[0], fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(text = parts[1], fontSize = 14.sp)
    }
}

@Composable
fun StatusButton(status: String) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (status == "Registered") Color(0xFFD6EAF8) else Color(0xFF7FD4DF),
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(20.dp),
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(
            text = status,
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}


