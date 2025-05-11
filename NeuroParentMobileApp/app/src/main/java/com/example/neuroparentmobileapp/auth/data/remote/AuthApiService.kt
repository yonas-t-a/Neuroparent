package com.example.neuroparentmobileapp.auth.data.remote

import com.example.neuroparentmobileapp.auth.data.dto.LoginRequest
import com.example.neuroparentmobileapp.auth.data.dto.LoginResponse
import com.example.neuroparentmobileapp.auth.data.dto.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest)

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}
