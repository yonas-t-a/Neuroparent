package com.example.neuroparentmobileapp.user.domain.model

data class UserProfile(
    val id: Int,
    val name: String,
    val email: String,
    val role: String
)