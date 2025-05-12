package com.example.neuroparentmobileapp.admin.data.repository

import com.example.neuroparentmobileapp.admin.data.dto.EventDto
import com.example.neuroparentmobileapp.admin.data.remote.AdminEventApiService
import com.example.neuroparentmobileapp.admin.domin.entity.Event
import com.example.neuroparentmobileapp.admin.domin.repository.AdminEventRepository


class AdminEventRepositoryImpl(
    private val api: AdminEventApiService
) : AdminEventRepository {
    override suspend fun createEvent(event: Event): Event =
        api.createEvent(event.toMap()).toDomain()

    override suspend fun getEventsByCreator(creatorId: Int): List<Event> =
        api.getEventsByCreator(creatorId).map { it.toDomain() }

    override suspend fun updateEvent(id: Int, event: Event): Event =
        api.updateEvent(id, event.toMap()).toDomain()

    override suspend fun deleteEvent(id: Int): String =
        api.deleteEvent(id)["message"] ?: "Unknown error"
}

// Extension functions for mapping
fun EventDto.toDomain() = Event(
    id = event_id ?: 0,
    title = event_title,
    description = event_description,
    date = event_date,
    time = event_time,
    location = event_location,
    category = event_category,
    creatorId = creator_id ?: 1,
    status = event_status == 1
)

fun Event.toMap() = mapOf(
    "event_title" to title,
    "event_description" to description,
    "event_date" to date,
    "event_time" to time,
    "event_location" to location,
    "event_category" to category,
    "creator_id" to creatorId.toString(),
    "event_status" to if (status) "1" else "0"
)
