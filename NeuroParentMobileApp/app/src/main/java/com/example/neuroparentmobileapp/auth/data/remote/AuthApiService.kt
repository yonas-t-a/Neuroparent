package com.example.neuroparentmobileapp.auth.data.remote


import com.example.neuroparentmobileapp.auth.data.remote.dto.LoginRequest
import com.example.neuroparentmobileapp.auth.data.remote.dto.LoginResponse
import com.example.neuroparentmobileapp.auth.data.remote.dto.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): LoginResponse
}
