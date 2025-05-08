package com.example.neuroparentmobileapp.user.domain.repository

import com.example.neuroparentmobileapp.user.domain.model.Event

interface EventRepository {
    suspend fun getEvents():  List<Event>
    suspend fun registerForEvent(userId: Int, eventId: Int)
    suspend fun cancelRegistration(userId: Int, eventId: Int)
    suspend fun getUserEvents(userId: Int): List<Int>
}