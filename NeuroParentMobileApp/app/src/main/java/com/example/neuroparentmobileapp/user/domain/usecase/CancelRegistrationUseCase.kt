package com.example.neuroparentmobileapp.user.domain.usecase

import com.example.neuroparentmobileapp.user.domain.repository.EventRepository

class CancelRegistrationUseCase(private val repository: EventRepository) {
    // suspend operator fun invoke(eventId: Int) {
    //     repository.cancelRegistration(eventId)
    // }
    suspend operator fun invoke(userId: Int, eventId: Int) {
        repository.cancelRegistration(userId, eventId)
    }
}