package com.example.neuroparentmobileapp.user.domain.usecase


import com.example.neuroparentmobileapp.user.domain.model.UserProfile
import com.example.neuroparentmobileapp.user.domain.repository.UserRepository

class UpdateProfileUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(userId: Int, userProfile: UserProfile) {
        repository.updateUserProfile(userId, userProfile)
    }
}