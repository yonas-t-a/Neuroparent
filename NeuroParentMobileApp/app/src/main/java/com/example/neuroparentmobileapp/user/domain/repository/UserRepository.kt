package com.example.neuroparentmobileapp.domain.repository

import com.example.neuroparentmobileapp.domain.model.UserProfile

interface UserRepository {
    suspend fun getUserProfile(userId: Int): UserProfile
    suspend fun updateUserProfile(userId: Int, userProfile: UserProfile)
}