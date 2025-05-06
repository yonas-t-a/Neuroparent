package com.example.neuroparentmobileapp.auth.data.repository

import com.example.neuroparentmobileapp.auth.data.local.AuthPreferences
import com.example.neuroparentmobileapp.auth.data.remote.AuthApiService
import com.example.neuroparentmobileapp.auth.domain.model.AuthUser
import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val apiService: AuthApiService,
    private val preferences: AuthPreferences
) : AuthRepository {

    override suspend fun login(email: String, password: String): AuthUser {
        val response = apiService.login(LoginRequest(email, password))
        preferences.saveToken(response.token)
        return response.user
    }

    override suspend fun register(name: String, email: String, password: String): AuthUser {
        val response = apiService.register(RegisterRequest(name, email, password))
        preferences.saveToken(response.token)
        return response.user
    }

    override fun logout() {
        preferences.clearToken()
    }
}
