package com.example.neuroparentmobileapp.admin.domin.usercase


import com.example.neuroparentmobileapp.admin.domin.entity.Event
import com.example.neuroparentmobileapp.admin.domin.repository.AdminEventRepository

class UpdateEventUseCase(private val repo: AdminEventRepository) {
    suspend operator fun invoke(id: Int, event: Event) = repo.updateEvent(id, event)
} 