package com.example.neuroparentmobileapp.core.navigation

import com.example.neuroparent.admin.presentation.Profile.AdminProfile

// core/navigation/Screen.kt
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object SignUp : Screen("signup")
    object Eventsscreen : Screen("EventsScreen")
    object Homescreen : Screen("HomeScreen")
    object Userevents : Screen("UserEventsScreen")
    object Usereditprofile : Screen("EditProfileScreen")
    object Userprofile : Screen("ProfileScreen")
    object Adminaddedit : Screen("AddEdit")
    object Adminaddevent : Screen("CreateEventScreen")
    object Admineditevent : Screen("EditEventScreen")
    object Adminevents : Screen("AdminEventsScreen")
    object Adminprofile : Screen("AdminProfile")
    object Admineditprofile : Screen("AdminEditProfile")
    object Adminarticles : Screen("AdminArticlesScreen")
    object Admineditarticle : Screen("EditArticleScreen")
    object AdminCreatearticle : Screen("CreateArticlesScreen")
    object Adminhomescreen : Screen("AdminHomeScreen")
    object Adminallevent : Screen("AdminAllEvent")


    // Add other screens here as needed
}