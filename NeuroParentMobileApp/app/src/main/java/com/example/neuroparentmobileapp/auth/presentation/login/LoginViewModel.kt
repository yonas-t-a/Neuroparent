package com.example.neuroparentmobileapp.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.auth.data.repository.TokenManager
import com.example.neuroparentmobileapp.auth.domain.usecase.LoginUseCase

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch



class LogInViewModel(
    private val loginUseCase: LoginUseCase,
    private val tokenManager: TokenManager
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun onEmailChange(value: String) { _email.value = value }
    fun onPasswordChange(value: String) { _password.value = value }

    fun LogIn(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            val result = loginUseCase(email.value, password.value)
            result.onSuccess { token ->
                tokenManager.saveToken(token)
                onSuccess()
            }.onFailure {
                _error.value = it.message
            }
            _loading.value = false
        }
    }
}

class LogInViewModelFactory(
    private val loginUseCase: LoginUseCase,
    private val tokenManager: TokenManager
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LogInViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LogInViewModel(loginUseCase, tokenManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}