package com.example.neuroparentmobileapp.admin.data.repository

import com.example.neuroparentmobileapp.admin.data.remote.AdminEventApiService
import com.example.neuroparentmobileapp.admin.data.remote.dto.AdminEventDto
import com.example.neuroparentmobileapp.admin.data.remote.dto.toDomain
import com.example.neuroparentmobileapp.admin.data.remote.dto.toDto
import com.example.neuroparentmobileapp.domain.model.AdminEvent
import com.example.neuroparentmobileapp.domain.repository.AdminEventRepository

class AdminEventRepositoryImpl(
    private val apiService: AdminEventApiService
) : AdminEventRepository {
    override suspend fun createEvent(event: AdminEvent, token: String) {
        val dto = event.toDto(adminId = event.id ?: 0) // Pass correct adminId
        apiService.createEvent(token, dto)
    }

    override suspend fun updateEvent(id: Int, event: AdminEvent, token: String) {
        val dto = event.toDto(adminId = event.id ?: 0) // Pass correct adminId
        apiService.updateEvent(token, id, dto)
    }

    override suspend fun deleteEvent(id: Int, token: String) {
        apiService.deleteEvent(token, id)
    }

    override suspend fun getAllEvents(token: String): List<AdminEvent> {
        return apiService.getAllEvents(token).map(AdminEventDto::toDomain)
    }

    override suspend fun getEventsByAdmin(adminId: Int, token: String): List<AdminEvent> {
        return apiService.getAllEvents(token)
            .filter { it.creator_id == adminId }
            .map(AdminEventDto::toDomain)
    }
}