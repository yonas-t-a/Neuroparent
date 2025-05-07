package com.example.neuroparentmobileapp.user.domain.usecase


import com.example.neuroparentmobileapp.user.domain.model.UserProfile
import com.example.neuroparentmobileapp.user.domain.repository.UserRepository

class GetUserProfileUseCase(private val repository: UserRepository) {
    suspend operator fun invoke(userId: Int): UserProfile {
        return repository.getUserProfile(userId)
    }
}