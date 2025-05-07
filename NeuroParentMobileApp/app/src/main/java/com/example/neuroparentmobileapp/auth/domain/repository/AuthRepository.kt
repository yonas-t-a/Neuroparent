package com.example.neuroparentmobileapp.auth.domain.repository

import com.example.neuroparentmobileapp.auth.domain.model.AuthUser
import com.example.neuroparentmobileapp.auth.data.repository.Resource

interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthUser>
    suspend fun register(name: String, email: String, password: String): Resource<AuthUser>
    suspend fun logout()
}