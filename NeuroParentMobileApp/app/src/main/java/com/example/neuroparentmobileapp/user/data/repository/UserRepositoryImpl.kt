package com.example.neuroparentmobileapp.data.repository

import com.example.neuroparentmobileapp.data.remote.UserApiService
import com.example.neuroparentmobileapp.domain.model.UserProfile
import com.example.neuroparentmobileapp.domain.repository.UserRepository

class UserRepositoryImpl(private val apiService: UserApiService) : UserRepository {
    override suspend fun getUserProfile(id: Int): UserProfile {
        return apiService.getUserProfile(id)
    }

    override suspend fun updateUserProfile(id: Int, userProfile: UserProfile) {
        apiService.updateUserProfile(id, userProfile)
    }
}