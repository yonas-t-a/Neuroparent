package com.example.neuroparentmobileapp.auth.domain.usecase

class ValidateCredentialsUseCase {
    operator fun invoke(email: String, password: String): Boolean {
        return email.isNotBlank() && password.isNotBlank() && password.length >= 6
    }
}