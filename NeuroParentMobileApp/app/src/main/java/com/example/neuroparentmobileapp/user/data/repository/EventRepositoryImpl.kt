package com.example.neuroparentmobileapp.user.data.repository

import com.example.neuroparentmobileapp.user.data.remote.EventApiService
import com.example.neuroparentmobileapp.user.data.remote.dto.toDomain
import com.example.neuroparentmobileapp.user.data.remote.dto.UserEventDto
import com.example.neuroparentmobileapp.user.domain.model.Event
import com.example.neuroparentmobileapp.user.domain.repository.EventRepository

class EventRepositoryImpl(private val apiService: EventApiService) : EventRepository {
    override suspend fun getEvents(): List<Event> {
        return apiService.getEvents().map { it.toDomain() }
    }

    override suspend fun registerForEvent(userId: Int, eventId: Int) {
        apiService.registerForEvent(userId, eventId)
    }

    override suspend fun cancelRegistration(userId: Int, eventId: Int) {
        apiService.cancelRegistration(userId, eventId)
    }

    override suspend fun getUserEvents(userId: Int): List<Int> {
        return apiService.getUserEvents()
            .filter { it.user_id == userId }
            .map { it.event_id }
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