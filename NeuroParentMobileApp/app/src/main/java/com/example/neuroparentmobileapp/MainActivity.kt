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
import com.example.neuroparentmobileapp.auth.data.local.AuthPreferences
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext

//@HiltAndroidApp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navigationManager = remember { NavigationManager() }
            val context = LocalContext.current
            val authPreferences = remember { AuthPreferences(context) }
            val token by authPreferences.token.collectAsState(initial = null)
            val isAuthenticated = token != null

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
                    isAuthenticated = isAuthenticated
                )
            }
        }
    }
}
