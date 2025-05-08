// core/navigation/NavigationManager.kt
package com.example.neuroparentmobileapp.core.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import AppNavigator
import androidx.navigation.navOptions

class NavigationManager : AppNavigator {
    private val navigationCommands = Channel<NavigationCommand>(Channel.UNLIMITED)
    val commands = navigationCommands.receiveAsFlow()

    override fun navigateTo(route: String) {
        navigationCommands.trySend(NavigationCommand.NavigateTo(route))
    }

    override fun popBackStack() {
        navigationCommands.trySend(NavigationCommand.PopBackStack)
    }

    override fun navigateToLogin() = navigateTo(Screen.Login.route)
    override fun navigateToSignUp() = navigateTo(Screen.SignUp.route)
    override fun navigateToEvent() = navigateTo(Screen.Eventsscreen.route)
    override fun navigateToUserEditEvent() = navigateTo(Screen.Userevents.route)
    override fun navigateToUserProfile()  = navigateTo(Screen.Userprofile.route)
    override fun navigateToUserProfileEdit() = navigateTo(Screen.Usereditprofile.route)
    override fun navigateToAddEvent() = navigateTo(Screen.Adminaddevent.route)
    override fun navigateToEditEvent() = navigateTo(Screen.Admineditevent.route)
    override fun navigateToAdminEvents() = navigateTo(Screen.Adminevents.route)
    override fun navigateToAdminProfile() = navigateTo(Screen.Adminprofile.route)
    override fun navigateToAdminEditProfile() = navigateTo(Screen.Admineditprofile.route)
    override fun navigateToAdminArticles() = navigateTo(Screen.Adminarticles.route)
    override fun navigateToAdminEditArticle() = navigateTo(Screen.Admineditarticle.route)
    override fun navigateToAdminCreateArticle() = navigateTo(Screen.AdminCreatearticle.route)
    override fun navigateToAdminHomeScreen() = navigateTo(Screen.Adminhomescreen.route)
    override fun navigateToAdminAllEvent() = navigateTo(Screen.Adminallevent.route)
}

sealed class NavigationCommand {
    data class NavigateTo(val route: String) : NavigationCommand()
    object PopBackStack : NavigationCommand()
}