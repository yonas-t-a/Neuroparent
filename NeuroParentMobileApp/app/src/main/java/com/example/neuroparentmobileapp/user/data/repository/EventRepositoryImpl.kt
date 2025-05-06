package com.example.neuroparentmobileapp.data.repository

import com.example.neuroparentmobileapp.data.remote.EventApiService
import com.example.neuroparentmobileapp.domain.model.Event
import com.example.neuroparentmobileapp.domain.repository.EventRepository

class EventRepositoryImpl(private val apiService: EventApiService) : EventRepository {
    override suspend fun getEvents(): List<Event> {
        return apiService.getEvents()
    }

    override suspend fun registerForEvent(id: Int) {
        apiService.registerForEvent(id)
    }

    override suspend fun cancelRegistration(id: Int) {
        apiService.cancelRegistration(id)
    }
}