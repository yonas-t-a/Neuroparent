package com.example.neuroparentmobileapp.user.data.remote


import com.example.neuroparentmobileapp.user.data.remote.dto.UserProfileDto
import com.example.neuroparentmobileapp.user.domain.model.UserProfile
import retrofit2.http.*

interface UserApiService {

    @GET("users")
    suspend fun getAllUsers(): List<UserProfileDto> // admin only

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserProfileDto

    @POST("users")
    suspend fun createUser(@Body user: UserProfileDto): UserProfileDto

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body user: UserProfile): UserProfileDto

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: Int)
}
