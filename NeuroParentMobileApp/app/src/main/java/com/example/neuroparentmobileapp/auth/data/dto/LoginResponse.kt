package com.example.neuroparentmobileapp.auth.data.dto

data class LoginResponse(
    val token: String,
    val user: User
) {
    data class User(
        val id: String,
        val role: String
    )
}