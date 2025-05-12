package com.example.neuroparentmobileapp.auth.domain.repository


interface AuthRepository {
    suspend fun register(name: String, email: String, password: String): Result<Unit>
    suspend fun login(email: String, password: String): Result<String> // returns JWT token
    suspend fun getUserRole(token: String): Result<String>
    suspend fun logout()
}