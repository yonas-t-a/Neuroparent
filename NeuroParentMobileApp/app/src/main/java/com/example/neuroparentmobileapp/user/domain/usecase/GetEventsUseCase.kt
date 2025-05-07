package com.example.neuroparentmobileapp.user.domain.usecase


import com.example.neuroparentmobileapp.user.data.remote.dto.EventDto
import com.example.neuroparentmobileapp.user.domain.model.Event
import com.example.neuroparentmobileapp.user.domain.repository.EventRepository

class GetEventsUseCase(private val repository: EventRepository) {
    suspend operator fun invoke(): List<EventDto> {
        return repository.getEvents()
    }
}