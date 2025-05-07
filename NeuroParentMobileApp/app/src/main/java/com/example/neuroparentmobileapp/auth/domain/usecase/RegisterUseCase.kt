package com.example.neuroparentmobileapp.auth.domain.usecase

import com.example.neuroparentmobileapp.auth.domain.model.AuthUser
import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository
import com.example.neuroparentmobileapp.auth.data.repository.Resource

class RegisterUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(name: String, email: String, password: String): Resource<AuthUser> {
        return repository.register(name, email, password)
    }
}