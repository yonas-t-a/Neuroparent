package com.example.neuroparentmobileapp.user.domain.repository

import com.example.neuroparentmobileapp.user.domain.model.UserProfile

interface UserRepository {
    suspend fun getUserProfile(userId: Int): UserProfile
    suspend fun updateUserProfile(userId: Int, userProfile: UserProfile)
}