package com.example.neuroparentmobileapp.admin.domin.repository

import com.example.neuroparentmobileapp.admin.domin.entity.Event


interface AdminEventRepository {
    suspend fun createEvent(event: Event): Event
    suspend fun getEventsByCreator(creatorId: Int): List<Event>
    suspend fun updateEvent(id: Int, event: Event): Event
    suspend fun deleteEvent(id: Int): String
}






