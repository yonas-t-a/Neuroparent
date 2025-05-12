package com.example.neuroparentmobileapp.auth.domain.usecase

import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository

class LogoutUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}