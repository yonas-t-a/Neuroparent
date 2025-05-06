package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.repository.EventRepository

class CancelRegistrationUseCase(private val repository: EventRepository) {
    suspend operator fun invoke(eventId: Int) {
        repository.cancelRegistration(eventId)
    }
}