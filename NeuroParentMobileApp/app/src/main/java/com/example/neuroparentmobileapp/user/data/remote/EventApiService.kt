package com.example.neuroparentmobileapp.user.data.remote


import com.example.neuroparentmobileapp.user.data.remote.dto.EventDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface EventApiService {

    @GET("events")
    suspend fun getEvents(): List<EventDto>

    @GET("events/{id}")
    suspend fun getEventById(@Path("id") id: String): EventDto

    @GET("events/category/{category}")
    suspend fun getEventsByCategory(@Path("category") category: String): List<EventDto>

    @GET("events/date/{date}")
    suspend fun getEventsByDate(@Path("date") date: String): List<EventDto>

    @GET("events/location/{location}")
    suspend fun getEventsByLocation(@Path("location") location: String): List<EventDto>

    @GET("userEvents")
    suspend fun getUserEvents(): List<EventDto>

    @POST("userEvents")
    suspend fun registerForEvent(
        @Query("user_id") userId: Int,
        @Query("event_id") eventId: Int
    )

    @POST("userEvents/cancel")
    suspend fun cancelRegistration(
        @Query("user_id") userId: Int,
        @Query("event_id") eventId: Int
    )
}
