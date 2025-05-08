package com.example.neuroparentmobileapp.core.navigation

// core/navigation/AppNavigator.kt
interface AppNavigator {
    fun navigateTo(route: String)
    fun popBackStack()
    fun navigateToLogin()
    fun navigateToSignUp()
    fun navigateToEvent()
    fun navigateToUserEditEvent()
    fun navigateToUserProfileEdit()
    fun navigateToUserProfile()
    fun navigateToAddEvent()
    fun navigateToEditEvent()
    fun navigateToAdminEvents()
    fun navigateToAdminProfile()
    fun navigateToAdminEditProfile()
    fun navigateToAdminArticles()
    fun navigateToAdminCreateArticle()
    fun navigateToAdminEditArticle()
    fun navigateToAdminHomeScreen()
    fun navigateToAdminAllEvent()


    // Add other navigation methods as needed
}