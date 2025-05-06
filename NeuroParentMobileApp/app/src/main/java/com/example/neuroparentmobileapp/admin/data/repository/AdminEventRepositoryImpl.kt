package com.example.neuroparentmobileapp.admin.data.repository

import com.example.neuroparentmobileapp.admin.data.remote.AdminEventApiService
import com.example.neuroparentmobileapp.domain.model.AdminEvent
import com.example.neuroparentmobileapp.domain.repository.AdminEventRepository

class AdminEventRepositoryImpl(
    private val apiService: AdminEventApiService
) : AdminEventRepository {
    override suspend fun createEvent(event: AdminEvent) {
        apiService.createEvent(event)
    }

    override suspend fun updateEvent(id: Int, event: AdminEvent) {
        apiService.updateEvent(id, event)
    }

    override suspend fun deleteEvent(id: Int) {
        apiService.deleteEvent(id)
    }
}