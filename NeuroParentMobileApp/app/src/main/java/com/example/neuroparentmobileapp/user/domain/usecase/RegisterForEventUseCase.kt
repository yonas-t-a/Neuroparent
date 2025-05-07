package com.example.neuroparentmobileapp.user.domain.usecase


import com.example.neuroparentmobileapp.user.domain.repository.EventRepository

class RegisterForEventUseCase(private val repository: EventRepository) {
    // suspend operator fun invoke(eventId: Int) {
    //     repository.registerForEvent(eventId)
    // }
    suspend operator fun invoke(userId: Int, eventId: Int) {
        repository.registerForEvent(userId, eventId)
    }
}