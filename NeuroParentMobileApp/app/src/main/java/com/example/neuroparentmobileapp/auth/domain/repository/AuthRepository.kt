package com.example.neuroparentmobileapp.auth.domain.repository

import com.example.neuroparentmobileapp.auth.domain.model.AuthUser

interface AuthRepository {
    suspend fun login(email: String, password: String): AuthUser
    suspend fun register(name: String, email: String, password: String): AuthUser
    fun logout()
}