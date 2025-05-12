package com.example.neuroparentmobileapp.admin.data.remote
import com.example.neuroparentmobileapp.admin.data.dto.EventDto
import retrofit2.http.*

interface AdminEventApiService {
    @POST("events")
    suspend fun createEvent(@Body event: Map<String, String>): EventDto

    @GET("events/creator/{creatorid}")
    suspend fun getEventsByCreator(@Path("creatorid") creatorId: Int): List<EventDto>

    @PUT("events/{id}")
    suspend fun updateEvent(@Path("id") id: Int, @Body event: Map<String, String>): EventDto

    @DELETE("events/{id}")
    suspend fun deleteEvent(@Path("id") id: Int): Map<String, String>
}
