package com.example.neuroparentmobileapp.auth.domain.usecase

import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository


class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String) =
        repository.login(email, password)
}