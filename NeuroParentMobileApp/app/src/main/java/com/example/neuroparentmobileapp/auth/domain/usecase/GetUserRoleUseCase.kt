package com.example.neuroparentmobileapp.auth.domain.usecase

import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository


class GetUserRoleUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(token: String) =
        repository.getUserRole(token)
}