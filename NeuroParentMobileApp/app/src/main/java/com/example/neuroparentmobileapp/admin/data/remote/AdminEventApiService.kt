

package com.example.neuroparentmobileapp.admin.data.remote

import com.example.neuroparentmobileapp.admin.data.remote.dto.AdminEventDto
import retrofit2.http.*

interface AdminEventApiService {
    @GET("events")
    suspend fun getAllEvents(@Header("Authorization") token: String): List<AdminEventDto>

    @POST("events")
    suspend fun createEvent(
        @Header("Authorization") token: String,
        @Body event: AdminEventDto
    ): AdminEventDto

    @PUT("events/{id}")
    suspend fun updateEvent(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Body event: AdminEventDto
    ): AdminEventDto

    @DELETE("events/{id}")
    suspend fun deleteEvent(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    )
}