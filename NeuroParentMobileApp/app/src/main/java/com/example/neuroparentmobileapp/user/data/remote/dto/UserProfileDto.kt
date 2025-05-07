package com.example.neuroparentmobileapp.user.data.remote.dto

import com.example.neuroparentmobileapp.user.domain.model.UserProfile

data class UserProfileDto(
    val id: Int,
    val name: String,
    val email: String,
    val role: String
)

fun UserProfileDto.toDomain(): UserProfile {
    return UserProfile(
        id, name, email,
        role = "user"
    )
}