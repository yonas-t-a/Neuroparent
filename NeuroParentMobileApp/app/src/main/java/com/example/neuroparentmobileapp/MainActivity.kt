package com.example.neuroparentmobileapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.neuroparentmobileapp.auth.presentation.AuthViewModel
import com.example.neuroparentmobileapp.auth.presentation.login.LoginScreen
import com.example.neuroparentmobileapp.ui.theme.NeuroParentMobileAppTheme

class MainActivity : ComponentActivity() {
    private val authViewModel: AuthViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NeuroParentMobileAppTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Set LoginScreen as the main content
                    LoginScreen(
                        viewModel = authViewModel,
                        onLoginSuccess = {
                            // Navigate to another screen or show a success message
                            // For now, let's show a Toast
                            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    }
}
