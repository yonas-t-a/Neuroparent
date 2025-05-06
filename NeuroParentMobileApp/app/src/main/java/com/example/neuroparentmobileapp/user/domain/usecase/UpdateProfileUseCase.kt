package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.UserProfile
import com.example.neuroparentmobileapp.domain.repository.UserRepository

class UpdateProfileUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(userId: Int, userProfile: UserProfile) {
        repository.updateUserProfile(userId, userProfile)
    }
}