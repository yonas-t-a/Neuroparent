package com.example.neuroparentmobileapp.admin.domin.usercase

import com.example.neuroparentmobileapp.admin.domin.repository.AdminEventRepository


class DeleteEventUseCase(private val repo: AdminEventRepository) {
    suspend operator fun invoke(id: Int) = repo.deleteEvent(id)
} 