package com.example.neuroparentmobileapp.admin.domin.usercase


import com.example.neuroparentmobileapp.admin.domin.entity.Event
import com.example.neuroparentmobileapp.admin.domin.repository.AdminEventRepository

class CreateEventUseCase(private val repo: AdminEventRepository) {
    suspend operator fun invoke(event: Event) = repo.createEvent(event)
}
