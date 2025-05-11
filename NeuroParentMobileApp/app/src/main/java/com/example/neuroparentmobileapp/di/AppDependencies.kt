package com.example.neuroparentmobileapp.di

import android.content.Context
import com.example.neuroparentmobileapp.auth.data.remote.AuthApiService
import com.example.neuroparentmobileapp.auth.data.repository.AuthRepositoryImpl
import com.example.neuroparentmobileapp.auth.data.repository.TokenManager
import com.example.neuroparentmobileapp.auth.domain.repository.AuthRepository
import com.example.neuroparentmobileapp.auth.domain.usecase.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

class AppDependencies(context: Context) {
    val authApiService: AuthApiService by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:3500/api/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApiService::class.java)
    }
    val tokenManager = TokenManager(context)
    val authRepository: AuthRepository by lazy { AuthRepositoryImpl(authApiService) }
    val registerUseCase by lazy { RegisterUseCase(authRepository) }
    val loginUseCase by lazy { LoginUseCase(authRepository) }
    val getUserRoleUseCase by lazy { GetUserRoleUseCase(authRepository) }
    val logoutUseCase by lazy { LogoutUseCase(authRepository) }
} 