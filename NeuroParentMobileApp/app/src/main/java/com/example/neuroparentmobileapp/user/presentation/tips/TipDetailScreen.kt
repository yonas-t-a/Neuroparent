package com.example.neuroparentmobileapp.user.presentation.tips


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavItem
import com.example.neuroparentmobileapp.shared.components.navigation.BottomNavigationBar


@Composable
fun TipDetailScreen(
    modifier: Modifier = Modifier,
    photos: Array<Int>,
    articleTitle: Array<String>,
    articleLittleDescription: Array<String>,
    itemIndex: Int?,
    navController: NavController
) {
    if (itemIndex == null || itemIndex !in photos.indices) {
        Text(
            text = "Invalid item",
            color = Color.Red,
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
        return
    }

    val title = articleTitle[itemIndex]
    val description = articleLittleDescription[itemIndex]
    val image = photos[itemIndex]

    val bottomNavItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Ideas,
        BottomNavItem.Calendar,
        BottomNavItem.Edit,
        BottomNavItem.Profile
    )

    val currentRoute = navController.currentDestination?.route ?: BottomNavItem.Calendar.route

    Scaffold(bottomBar = {
        BottomNavigationBar(
            navController = navController,
            items = bottomNavItems,
            currentRoute = currentRoute
        )
    }) { innerpadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .padding(16.dp)

                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = description.substring(0, minOf(33, description.length)).plus("..."),
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Box(modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = title,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxWidth()
                )
            }
            Text(
                text = description,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

    }


}