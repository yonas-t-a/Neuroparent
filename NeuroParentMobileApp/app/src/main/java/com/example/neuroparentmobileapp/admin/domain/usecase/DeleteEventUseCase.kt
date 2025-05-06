package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.repository.AdminEventRepository

class DeleteEventUseCase(private val repository: AdminEventRepository) {
    suspend operator fun invoke(eventId: Int) {
        repository.deleteEvent(eventId)
    }
}