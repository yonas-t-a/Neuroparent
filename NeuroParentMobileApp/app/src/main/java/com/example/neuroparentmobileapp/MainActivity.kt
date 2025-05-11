package com.example.neuroparentmobileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.neuroparentmobileapp.core.navigation.AppNavHost
import com.example.neuroparentmobileapp.core.navigation.NavigationCommand
import com.example.neuroparentmobileapp.core.navigation.NavigationManager
import com.example.neuroparentmobileapp.ui.theme.NeuroParentMobileAppTheme
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.collectLatest
//import com.example.neuroparentmobileapp.auth.data.local.AuthPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import com.example.neuroparentmobileapp.auth.data.repository.TokenManager
import com.example.neuroparentmobileapp.di.AppDependencies
import com.example.neuroparentmobileapp.core.navigation.Screen
import kotlinx.coroutines.launch

//@HiltAndroidApp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navigationManager = remember { NavigationManager() }
            val context = LocalContext.current
            val appDependencies = remember { AppDependencies(context) }
            val tokenManager = appDependencies.tokenManager
            val getUserRoleUseCase = appDependencies.getUserRoleUseCase
            val token by tokenManager.token.collectAsState(initial = null)
            val alreadyNavigated = remember { mutableStateOf(false) }

            LaunchedEffect(token) {
                if (token.isNullOrEmpty()) {
                    alreadyNavigated.value = false
                    if (navController.currentDestination?.route != Screen.Login.route) {
                        navController.navigate(Screen.Login.route) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                } else if (!alreadyNavigated.value) {
                    // Check user role and navigate accordingly
                    kotlinx.coroutines.CoroutineScope(kotlinx.coroutines.Dispatchers.Main).launch {
                        val result = getUserRoleUseCase(token!!)
                        result.onSuccess { role ->
                            alreadyNavigated.value = true
                            if (role == "admin") {
                                navController.navigate(Screen.Adminhomescreen.route) {
                                    popUpTo(0) { inclusive = true }
                                }
                            } else {
                                navController.navigate(Screen.Homescreen.route) {
                                    popUpTo(0) { inclusive = true }
                                }
                            }
                        }
                        // Optionally handle failure
                    }
                }
            }

            LaunchedEffect(Unit) {
                navigationManager.commands.collectLatest { command ->
                    when (command) {
                        is NavigationCommand.NavigateTo -> {
                            navController.navigate(command.route)
                        }
                        NavigationCommand.PopBackStack -> {
                            navController.popBackStack()
                        }
                    }
                }
            }

            NeuroParentMobileAppTheme {
                AppNavHost(
                    navController = navController,
                    navigationManager = navigationManager,
                    loginUseCase = appDependencies.loginUseCase,
                    tokenManager = appDependencies.tokenManager
                )
            }
        }
    }
}
