package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.UserProfile
import com.example.neuroparentmobileapp.domain.repository.UserRepository

class GetUserProfileUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(userId: Int): UserProfile {
        return repository.getUserProfile(userId)
    }
}