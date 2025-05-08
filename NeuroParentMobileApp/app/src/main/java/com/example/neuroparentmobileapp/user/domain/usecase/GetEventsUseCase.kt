package com.example.neuroparentmobileapp.user.domain.usecase

import com.example.neuroparentmobileapp.user.domain.model.Event
import com.example.neuroparentmobileapp.user.domain.repository.EventRepository

class GetEventsUseCase(private val repository: EventRepository) {
    suspend operator fun invoke(): List<Event> {
        return repository.getEvents()
    }

    suspend fun registeredEvents(userId: Int): List<Event> {
        val allEvents = repository.getEvents()
        val registeredIds = repository.getUserEvents(userId)
        return allEvents.filter { it.id in registeredIds }
    }

    suspend fun unregisteredEvents(userId: Int): List<Event> {
        val allEvents = repository.getEvents()
        val registeredIds = repository.getUserEvents(userId)
        return allEvents.filter { it.id !in registeredIds }
    }
}