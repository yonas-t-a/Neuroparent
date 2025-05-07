package com.example.neuroparentmobileapp.auth.domain.usecase

import com.example.neuroparentmobileapp.auth.domain.model.AuthUser
import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository
import com.example.neuroparentmobileapp.auth.data.repository.Resource

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email: String, password: String): Resource<AuthUser> {
        return repository.login(email, password)
    }
}