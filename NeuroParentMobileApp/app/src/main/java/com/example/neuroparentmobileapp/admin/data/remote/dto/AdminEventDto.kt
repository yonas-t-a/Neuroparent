package com.example.neuroparentmobileapp.admin.data.remote.dto

import com.example.neuroparentmobileapp.admin.domain.model.AdminEvent

// Matches backend API response
// { event_id, event_title, event_description, event_date, event_time, event_location, event_category, creator_id, event_status }
data class AdminEventDto(
    val event_id: Int,
    val event_title: String,
    val event_description: String,
    val event_date: String,
    val event_time: String,
    val event_location: String,
    val event_category: String,
    val creator_id: Int,
    val event_status: Boolean
)

fun AdminEventDto.toDomain(): AdminEvent = AdminEvent(
    id = event_id,
    name = event_title,
    description = event_description,
    date = event_date,
    location = event_location
)

fun AdminEvent.toDto(adminId: Int): AdminEventDto = AdminEventDto(
    event_id = id ?: 0,
    event_title = name,
    event_description = description,
    event_date = date,
    event_time = "",
    event_location = location,
    event_category = "",
    creator_id = adminId,
    event_status = true
) 