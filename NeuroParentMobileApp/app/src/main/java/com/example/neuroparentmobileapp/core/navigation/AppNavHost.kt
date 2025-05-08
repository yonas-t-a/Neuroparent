package com.example.neuroparent.core.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.neuroparent.admin.presentation.events.AdminEventsScreen
import com.example.neuroparent.admin.presentation.events.CreateEventScreen
import com.example.neuroparent.admin.presentation.events.EditEventScreen
import com.example.neuroparent.admin.presentation.home.AddEdit
import com.example.neuroparent.auth.presentation.login.Login
import com.example.neuroparent.auth.presentation.signup.SignUp
import com.example.neuroparent.user.presentation.events.EventsScreen
import com.example.neuroparent.user.presentation.home.HomeScreen
import com.example.neuroparent.user.presentation.events.UserEventsScreen
import com.example.neuroparent.user.presentation.profile.EditProfileScreen
import com.example.neuroparent.user.presentation.profile.ProfileScreen
import com.example.neuroparent.admin.presentation.Profile.AdminProfile
import com.example.neuroparent.admin.presentation.Profile.AdminEditProfile
import com.example.neuroparent.admin.presentation.articles.AdminArticlesScreen
import com.example.neuroparent.admin.presentation.articles.CreateArticleScreen
import com.example.neuroparent.admin.presentation.articles.EditArticleScreen
import com.example.neuroparent.admin.presentation.events.AdminAllEvent
import com.example.neuroparent.admin.presentation.home.AdminHomeScreen
import com.example.neuroparent.user.presentation.tips.TipslistScreen


@Composable
fun AppNavHost(navController: NavController, navigationManager: NavigationManager) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Adminhomescreen") {
        composable("login") {
            Login(navController = navController)
        }
        composable("signup") {
            SignUp(navController = navController)
        }
        composable("Eventsscreen") {
            EventsScreen(navController = navController)
        }
        composable("Homescreen"){
            HomeScreen(navController = navController)
        }
        composable("Userevents"){
            UserEventsScreen(navController = navController)
        }
        composable("Usereditprofile"){
            EditProfileScreen(navController = navController)
        }
        composable("Userprofile"){
            ProfileScreen(navController = navController)
        }
        composable("Adminaddevent"){
            CreateEventScreen(navController = navController)

        }
        composable("Admineditevent"){
            EditEventScreen(navController = navController)

        }
        composable("Adminaddedit"){
            AddEdit(navController = navController)

        }
        composable("Adminevents") {
            AdminEventsScreen(navController = navController)
        }
        composable("Adminprofile") {
            AdminProfile(navController = navController)

        }
        composable("Admineditprofile") {
            AdminEditProfile(navController = navController)

        }

        composable("Admineditarticle") {
            EditArticleScreen(navController = navController)
        }
        composable("Admincreatearticle") {
            CreateArticleScreen(navController = navController)
        }
        composable("AdminHomeScreen") {
            AdminHomeScreen(navController = navController)
        }
        composable ("AdminAllEvent") {
            AdminAllEvent(navController = navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    val navigationManager = NavigationManager()
    MaterialTheme {
        AppNavHost(navController = navController , navigationManager = NavigationManager())
    }
}
