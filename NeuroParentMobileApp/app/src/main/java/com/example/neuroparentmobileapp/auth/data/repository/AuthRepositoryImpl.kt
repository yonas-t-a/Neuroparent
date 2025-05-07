package com.example.neuroparentmobileapp.auth.data.repository

import auth.data.remote.AuthApiService
import com.example.neuroparentmobileapp.auth.data.local.AuthPreferences
import com.example.neuroparentmobileapp.auth.data.remote.dto.LoginRequest
import com.example.neuroparentmobileapp.auth.data.remote.dto.RegisterRequest
import com.example.neuroparentmobileapp.auth.domain.model.AuthUser
import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository

sealed class Resource<out T> {
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

class AuthRepositoryImpl(
    private val apiService: AuthApiService,
    private val preferences: AuthPreferences
) : AuthRepository {

    override suspend fun login(email: String, password: String): Resource<AuthUser> {
        return try {
            val response = apiService.login(LoginRequest(email, password))
            preferences.saveToken(response.token)
            Resource.Success(response.user)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun register(name: String, email: String, password: String): Resource<AuthUser> {
        return try {
            val response = apiService.register(RegisterRequest(name, email, password))
            preferences.saveToken(response.token)
            Resource.Success(response.user)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }

    override suspend fun logout() {
        preferences.clearToken()
    }
}
