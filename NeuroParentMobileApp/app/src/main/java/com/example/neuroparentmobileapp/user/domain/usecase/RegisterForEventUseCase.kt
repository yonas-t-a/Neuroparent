package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.repository.EventRepository

class RegisterForEventUseCase(private val repository: EventRepository) {
    suspend operator fun invoke(eventId: Int) {
        repository.registerForEvent(eventId)
    }
}