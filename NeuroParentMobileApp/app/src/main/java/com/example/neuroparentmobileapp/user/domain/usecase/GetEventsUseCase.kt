package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.Event
import com.example.neuroparentmobileapp.domain.repository.EventRepository

class GetEventsUseCase(private val repository: EventRepository) {
    suspend operator fun invoke(): List<Event> {
        return repository.getEvents()
    }
}