package com.example.neuroparent.admin.presentation.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neuroparent.R
import androidx.navigation.NavController
import com.example.neuroparent.shared.components.navigation.BottomNavItem
import com.example.neuroparent.shared.components.navigation.BottomNavigationBar


@Composable
fun AddEdit(navController: NavController) {

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
    }) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Add",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(15.dp))

            // Add Section
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .clickable {},
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE3EBF5)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.t7),
                        contentDescription = "Add Tip-Event",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 10.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Tips and Tricks",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Add Tips and Tricks",
                            fontSize = 15.sp
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_ios_24),
                        contentDescription = "Go to details",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .clickable {navController.navigate("Adminaddevent")},
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE3EBF5)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.e1),
                        contentDescription = "Add Tip-Event",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 10.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Event",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Add Event",
                            fontSize = 15.sp
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_ios_24),
                        contentDescription = "Go to details",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }

            Spacer(Modifier.height(15.dp))

            // Edit Section
            Text(
                text = "Edit",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(15.dp))

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .clickable {},
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE3EBF5)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.t7),
                        contentDescription = "Edit Tip-Event",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 10.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Tips and Tricks",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Edit Tips and Tricks",
                            fontSize = 15.sp
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_ios_24),
                        contentDescription = "Go to details",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .clickable { navController.navigate("Adminevents")},
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFE3EBF5)
                )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.e1),
                        contentDescription = "Edit Tip-Event",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .padding(start = 10.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(12.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Event",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Edit Event",
                            fontSize = 15.sp
                        )
                    }
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_forward_ios_24),
                        contentDescription = "Go to details",
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                }
            }
        }
    }
}
