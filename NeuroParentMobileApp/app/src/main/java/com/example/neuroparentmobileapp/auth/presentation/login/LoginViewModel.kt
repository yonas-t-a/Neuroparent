package com.example.neuroparentmobileapp.auth.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.auth.domain.usecase.LoginUseCase
import com.example.neuroparentmobileapp.auth.domain.usecase.ValidateCredentialsUseCase
import com.example.neuroparentmobileapp.auth.data.repository.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// UI State for Login
// Expose token instead of user object

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val token: String? = null,
    val role: String? = null
)
@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val validateCredentials: ValidateCredentialsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email, error = null)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password, error = null)
    }

    fun login() {
        val email = _uiState.value.email
        val password = _uiState.value.password
        if (!validateCredentials(email, password)) {
            _uiState.value = _uiState.value.copy(error = "Invalid email or password")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = loginUseCase(email, password)) {
                is Resource.Success -> {
                    // Assume token is saved in preferences, but for UI, expose token and role from result if available
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        token = result.data?.let { it.email },
                        role = result.data?.role,
                        error = null
                    )
                }
                is Resource.Error -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                }
                is Resource.Loading -> {
                    _uiState.value = _uiState.value.copy(isLoading = true)
                }
            }
        }
    }
}
