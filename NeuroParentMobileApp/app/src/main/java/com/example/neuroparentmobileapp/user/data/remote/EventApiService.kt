package user.data.remote

import user.data.remote.dto.EventDto
import retrofit2.http.GET
import retrofit2.http.Path

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
}
