package com.example.neuroparentmobileapp.admin.domain.repository

import com.example.neuroparentmobileapp.admin.domain.model.AdminEvent

interface AdminEventRepository {
    suspend fun createEvent(event: AdminEvent, token: String)
    suspend fun updateEvent(id: Int, event: AdminEvent, token: String)
    suspend fun deleteEvent(id: Int, token: String)
    suspend fun getAllEvents(token: String): List<AdminEvent>
    suspend fun getEventsByAdmin(adminId: Int, token: String): List<AdminEvent>
}