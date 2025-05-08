package com.example.neuroparentmobileapp.user.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.neuroparentmobileapp.R

import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.navigation.NavController
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavItem
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavigationBar


@Composable
fun HomeScreen(navController: NavController) {
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
        }
    ) {innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp),
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color.Black,

                    ),
                textAlign = TextAlign.Start
            )


            Text(
                text = "NeuroParent",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp), // Removes any default padding
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color.Black,

                    ),
                textAlign = TextAlign.Start
            )


            Spacer(Modifier.height(16.dp))

            // Subtitle
            Text(
                text = "Empowering neurodivergent",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),

                )
            Text(
                text = "parenting through community ",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),

                )
            Text(
                text = "and support",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = 16.sp,
                    color = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),

                )


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
                            text = "Explore Tips",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "explore tips",
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
                    .clickable { navController.navigate("Eventsscreen")},
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
                            text = "Find an Event",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "find an Event",
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
            Text(text = "Community highlights",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp), // Removes any default padding
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,

                    ),
                textAlign = TextAlign.Start)

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

            Text(text = "Upcoming Events",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(7.dp), // Removes any default padding
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Black,

                    ),
                textAlign = TextAlign.Start)

            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .wrapContentSize()
                    .clickable {navController.navigate("Userevents")},
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