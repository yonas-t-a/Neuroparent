package com.example.neuroparentmobileapp.user.data.repository


import com.example.neuroparentmobileapp.user.data.remote.UserApiService
import com.example.neuroparentmobileapp.user.data.remote.dto.UserProfileDto
import com.example.neuroparentmobileapp.user.data.remote.dto.toDomain
import com.example.neuroparentmobileapp.user.domain.model.UserProfile
import com.example.neuroparentmobileapp.user.domain.repository.UserRepository

class UserRepositoryImpl(private val apiService: UserApiService) : UserRepository {
    // override suspend fun getUserProfile(id: Int): UserProfile {
    //     return apiService.getUserProfile(id)
    // }

    // override suspend fun updateUserProfile(id: Int, userProfile: UserProfile) {
    //     apiService.updateUserProfile(id, userProfile)
    // }
    override suspend fun getUserProfile(id: Int): UserProfile {
        return apiService.getUserById(id).toDomain()
    }

    override suspend fun updateUserProfile(id: Int, userProfile: UserProfile) {
        apiService.updateUser(id, userProfile)
    }
}