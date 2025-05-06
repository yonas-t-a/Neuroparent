// package com.example.neuroparentmobileapp.admin.data.remote

// import admin.data.remote.dto.EventDto
// import retrofit2.http.*

// interface AdminEventApiService {

//     @POST("events")
//     suspend fun createEvent(@Body event: EventDto): EventDto

//     @PUT("events/{id}")
//     suspend fun updateEvent(@Path("id") id: String, @Body event: EventDto): EventDto

//     @DELETE("events/{id}")
//     suspend fun deleteEvent(@Path("id") id: String)
// }

package com.example.neuroparentmobileapp.admin.data.remote

import com.example.neuroparentmobileapp.domain.model.AdminEvent
import retrofit2.http.*

interface AdminEventApiService {
    @POST("events")
    suspend fun createEvent(@Body event: AdminEvent)

    @PUT("events/{id}")
    suspend fun updateEvent(@Path("id") id: Int, @Body event: AdminEvent)

    @DELETE("events/{id}")
    suspend fun deleteEvent(@Path("id") id: Int)
}