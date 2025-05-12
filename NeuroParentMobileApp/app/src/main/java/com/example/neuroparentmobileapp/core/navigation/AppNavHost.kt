package com.example.neuroparentmobileapp.core.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
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
import com.example.neuroparentmobileapp.auth.data.repository.TokenManager
import com.example.neuroparentmobileapp.auth.domain.usecase.LoginUseCase
import com.example.neuroparentmobileapp.auth.presentation.login.Login
import com.example.neuroparentmobileapp.auth.presentation.signup.SignUp
import com.example.neuroparentmobileapp.user.presentation.events.EventsScreen
import com.example.neuroparentmobileapp.user.presentation.events.UserEventsScreen
import com.example.neuroparentmobileapp.user.presentation.home.EditProfileScreen
import com.example.neuroparentmobileapp.user.presentation.home.HomeScreen
import com.example.neuroparentmobileapp.user.presentation.home.ProfileScreen


@Composable
fun AppNavHost(navController: NavHostController, navigationManager: NavigationManager, loginUseCase: LoginUseCase,
               tokenManager: TokenManager) {
    // Check if user is authenticated
    val token by tokenManager.token.collectAsState(initial = null)
    val isLoggedIn = token != null

     NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "Homescreen" else "login"
    )  {
        composable("login") {
            Login(
                navController = navController,
                loginUseCase = loginUseCase,
                tokenManager = tokenManager,
                onSignInSuccess = {
                    navController.navigate("Homescreen") {
                        popUpTo("signin") { inclusive = true }
                    }
                }
            )
        }
        composable("Signup") {
            SignUp(
                navController = navController,
                onSignUpSuccess = {
                    navController.navigate("login") {
                        popUpTo("signup") { inclusive = true }}
                }
            )
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

