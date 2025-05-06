package com.example.neuroparentmobileapp.domain.repository

import com.example.neuroparentmobileapp.domain.model.Event

interface EventRepository {
    suspend fun getEvents(): List<Event>
    suspend fun registerForEvent(eventId: Int)
    suspend fun cancelRegistration(eventId: Int)
}