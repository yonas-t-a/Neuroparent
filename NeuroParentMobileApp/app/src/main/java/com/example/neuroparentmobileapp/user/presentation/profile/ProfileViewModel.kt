package com.example.neuroparentmobileapp.user.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.auth.data.repository.TokenManager
import com.example.neuroparentmobileapp.auth.domain.usecase.GetUserRoleUseCase
import com.example.neuroparentmobileapp.auth.domain.usecase.LogoutUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UserViewModel(
    private val tokenManager: TokenManager,
    private val getUserRoleUseCase: GetUserRoleUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {
    private val _role = MutableStateFlow("user")
    val role: StateFlow<String> = _role

    fun loadRole() {
        viewModelScope.launch {
            val token = tokenManager.token.first()
            if (token != null) {
                val result = getUserRoleUseCase(token)
                result.onSuccess { _role.value = it }
            }
        }
    }

    fun logout(onLoggedOut: () -> Unit) {
        viewModelScope.launch {
            logoutUseCase()
            onLoggedOut()
        }
    }
}

class UserViewModelFactory(
    private val tokenManager: TokenManager,
    private val getUserRoleUseCase: GetUserRoleUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(tokenManager, getUserRoleUseCase, logoutUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
