package com.example.neuroparent.shared.components.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*


sealed class BottomNavItem(
    val route: String,
    val icon: ImageVector,
    val contentDescription: String
) {

    //User
    object Home : BottomNavItem("Homescreen", Icons.Default.Home, "Home")
    object Ideas : BottomNavItem("Tips", Icons.Default.Info, "Ideas")
    object Calendar : BottomNavItem("Eventsscreen", Icons.Default.DateRange, "Calendar")
    object Edit : BottomNavItem("Userevents", Icons.Default.Edit, "Edit")
    object Profile : BottomNavItem("Userprofile", Icons.Default.Person, "Profile")


    //Admin

    object AdminHome : BottomNavItem("Adminhomescreen", Icons.Default.Home, "Home")
    object AdminIdeas : BottomNavItem("Adminevents", Icons.Default.Info, "Ideas")
    object AdminCalendar : BottomNavItem("Adminallevent", Icons.Default.DateRange, "Calendar")
    object AdminEdit : BottomNavItem("Admineditprofile", Icons.Default.Edit, "Edit")
    object AdminProfile : BottomNavItem("Adminprofile", Icons.Default.Person, "Profile")
    object Add : BottomNavItem("Adminaddedit", Icons.Default.Add, "Add")
}
