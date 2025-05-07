package com.example.neuroparentmobileapp.user.data.repository


import com.example.neuroparentmobileapp.user.data.remote.EventApiService
import com.example.neuroparentmobileapp.user.data.remote.dto.EventDto
import com.example.neuroparentmobileapp.user.domain.repository.EventRepository

class EventRepositoryImpl(private val apiService: EventApiService) : EventRepository {
     override suspend fun getEvents():  List<EventDto> {
         return apiService.getEvents()
     }

     override suspend fun registerForEvent(userId: Int, eventId: Int) {
        apiService.registerForEvent(userId, eventId)
    }

    override suspend fun cancelRegistration(userId: Int, eventId: Int) {
        apiService.cancelRegistration(userId, eventId)
    }
    //  Second

    //  override suspend fun registerForEvent(id: Int) {
    //      apiService.registerForEvent(id)
    //  }

    //  override suspend fun cancelRegistration(id: Int) {
    //      apiService.cancelRegistration(id)
    //  }

    //  First
//    override suspend fun getEvents(): List<Event> {
//        return apiService.getEvents().map { it.toDomain() }
//    }
//
//    override suspend fun registerForEvent(id: Int) {
//        apiService.registerForEvent(id)
//    }
//
//    override suspend fun cancelRegistration(id: Int) {
//        apiService.cancelRegistration(id)
//    }
}