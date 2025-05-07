package com.example.neuroparentmobileapp.auth.presentation.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.auth.domain.model.AuthUser
import com.example.neuroparentmobileapp.auth.domain.usecase.RegisterUseCase
import com.example.neuroparentmobileapp.auth.domain.usecase.ValidateCredentialsUseCase
import com.example.neuroparentmobileapp.auth.data.repository.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// UI State for Sign Up
data class SignUpUiState(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val error: String? = null,
    val user: AuthUser? = null
)

class SignUpViewModel(
    private val registerUseCase: RegisterUseCase,
    private val validateCredentials: ValidateCredentialsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState

    fun onNameChange(name: String) {
        _uiState.value = _uiState.value.copy(name = name, error = null)
    }

    fun onEmailChange(email: String) {
        _uiState.value = _uiState.value.copy(email = email, error = null)
    }

    fun onPasswordChange(password: String) {
        _uiState.value = _uiState.value.copy(password = password, error = null)
    }

    fun register() {
        val name = _uiState.value.name
        val email = _uiState.value.email
        val password = _uiState.value.password
        if (name.isBlank() || !validateCredentials(email, password)) {
            _uiState.value = _uiState.value.copy(error = "Invalid name, email, or password")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = registerUseCase(name, email, password)) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, user = result.data, error = null)
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
