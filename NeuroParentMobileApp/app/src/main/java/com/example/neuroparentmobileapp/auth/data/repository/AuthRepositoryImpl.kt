package com.example.neuroparentmobileapp.auth.data.repository

import com.example.neuroparentmobileapp.auth.data.remote.AuthApiService

import com.example.neuroparentmobileapp.auth.data.remote.dto.LoginRequest
import com.example.neuroparentmobileapp.auth.data.remote.dto.RegisterRequest
import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepositoryImpl(
    private val api: AuthApiService
) : AuthRepository {
    override suspend fun register(name: String, email: String, password: String) = withContext(Dispatchers.IO) {
        try {
            api.register(RegisterRequest(name, email, password))
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun login(email: String, password: String) = withContext(Dispatchers.IO) {
        try {
            val response = api.login(LoginRequest(email, password))
            Result.success(response.token)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getUserRole(token: String) = withContext(Dispatchers.IO) {
        try {
            val parts = token.split(".")
            if (parts.size == 3) {
                val payload = android.util.Base64.decode(parts[1], android.util.Base64.DEFAULT)
                val json = String(payload)
                val role = Regex("\"role\":\"(.*?)\"").find(json)?.groupValues?.get(1) ?: "user"
                Result.success(role)
            } else {
                Result.success("user")
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun logout() {
        // Clear token from DataStore if needed
    }
}
