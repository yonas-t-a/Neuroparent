package com.example.neuroparentmobileapp.auth.data.remote.dto

import com.example.neuroparentmobileapp.auth.domain.model.AuthUser

data class LoginResponse(
    val token: String,
    val user: AuthUser
)