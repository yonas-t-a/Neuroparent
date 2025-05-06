package com.example.neuroparentmobileapp.data.repository

import com.example.neuroparentmobileapp.data.remote.AdminEventApiService
import com.example.neuroparentmobileapp.domain.model.AdminEvent
import com.example.neuroparentmobileapp.domain.repository.AdminEventRepository

class AdminEventRepositoryImpl(
    private val apiService: AdminEventApiService
) : AdminEventRepository {
    override suspend fun createEvent(event: AdminEvent) {
        apiService.createEvent(event)
    }

   
}