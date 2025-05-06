package com.example.neuroparentmobileapp.domain.repository

import com.example.neuroparentmobileapp.domain.model.AdminEvent

interface AdminEventRepository {
    suspend fun createEvent(event: AdminEvent)
    
}