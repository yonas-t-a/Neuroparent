package com.example.neuroparentmobileapp.core.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neuroparentmobileapp.admin.presentation.Profile.AdminEditProfile
import com.example.neuroparentmobileapp.admin.presentation.Profile.AdminProfile
import com.example.neuroparentmobileapp.admin.presentation.articles.CreateArticleScreen
import com.example.neuroparentmobileapp.admin.presentation.articles.EditArticleScreen
import com.example.neuroparentmobileapp.admin.presentation.events.AdminAllEvent
import com.example.neuroparentmobileapp.admin.presentation.events.AdminEventsScreen
import com.example.neuroparentmobileapp.admin.presentation.events.CreateEventScreen
import com.example.neuroparentmobileapp.admin.presentation.events.EditEventScreen
import com.example.neuroparentmobileapp.admin.presentation.home.AddEdit
import com.example.neuroparentmobileapp.admin.presentation.home.AdminHomeScreen
import com.example.neuroparentmobileapp.auth.presentation.login.Login
import com.example.neuroparentmobileapp.auth.presentation.signup.SignUp
import com.example.neuroparentmobileapp.user.presentation.events.EventsScreen
import com.example.neuroparentmobileapp.user.presentation.events.UserEventsScreen
import com.example.neuroparentmobileapp.user.presentation.home.EditProfileScreen
import com.example.neuroparentmobileapp.user.presentation.home.HomeScreen
import com.example.neuroparentmobileapp.user.presentation.home.ProfileScreen
//import com.example.neuroparentmobileapp.core.Screen
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.collectAsState

@Composable
fun AppNavHost(
    navController: NavController,
    navigationManager: NavigationManager,
    isAuthenticated: Boolean
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            Login(navController = navController)
        }
        composable(Screen.SignUp.route) {
            SignUp(navController = navController)
        }
        // Protected routes
        if (isAuthenticated) {
            composable(Screen.Eventsscreen.route) {
                EventsScreen(navController = navController)
            }
            composable(Screen.Homescreen.route){
                HomeScreen(navController = navController)
            }
            composable(Screen.Userevents.route){
                UserEventsScreen(navController = navController)
            }
            composable(Screen.Usereditprofile.route){
                EditProfileScreen(navController = navController)
            }
            composable(Screen.Userprofile.route){
                ProfileScreen(navController = navController)
            }
            composable(Screen.Adminaddevent.route){
                CreateEventScreen(navController = navController)
            }
            composable(Screen.Admineditevent.route){
                EditEventScreen(navController = navController)
            }
            composable(Screen.Adminaddedit.route){
                AddEdit(navController = navController)
            }
            composable(Screen.Adminevents.route) {
                AdminEventsScreen(navController = navController)
            }
            composable(Screen.Adminprofile.route) {
                AdminProfile(navController = navController)
            }
            composable(Screen.Admineditprofile.route) {
                AdminEditProfile(navController = navController)
            }
            composable(Screen.Admineditarticle.route) {
                EditArticleScreen(navController = navController)
            }
            composable(Screen.AdminCreatearticle.route) {
                CreateArticleScreen(navController = navController)
            }
            composable(Screen.Adminhomescreen.route) {
                AdminHomeScreen(navController = navController)
            }
            composable(Screen.Adminallevent.route) {
                AdminAllEvent(navController = navController)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    val navigationManager = NavigationManager()
    MaterialTheme {
        AppNavHost(navController = navController , navigationManager = NavigationManager(), isAuthenticated = false)
    }
}
