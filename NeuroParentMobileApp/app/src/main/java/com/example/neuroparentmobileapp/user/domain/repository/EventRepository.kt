package com.example.neuroparentmobileapp.user.domain.repository

import com.example.neuroparentmobileapp.user.data.remote.dto.EventDto

interface EventRepository {
    suspend fun getEvents():  List<EventDto>
    suspend fun registerForEvent(userId: Int, eventId: Int)
    suspend fun cancelRegistration(userId: Int, eventId: Int)
}