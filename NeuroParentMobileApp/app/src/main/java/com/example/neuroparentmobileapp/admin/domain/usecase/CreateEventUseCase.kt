package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.AdminEvent
import com.example.neuroparentmobileapp.domain.repository.AdminEventRepository

class CreateEventUseCase(private val repository: AdminEventRepository) {
    suspend operator fun invoke(event: AdminEvent) {
        repository.createEvent(event)
    }
}