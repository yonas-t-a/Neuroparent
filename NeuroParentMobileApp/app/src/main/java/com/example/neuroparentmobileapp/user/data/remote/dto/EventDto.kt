package com.example.neuroparentmobileapp.user.data.remote.dto

import com.example.neuroparentmobileapp.user.domain.model.Event

data class EventDto(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val category: String
)

data class UserEventDto(
    val user_event_id: Int,
    val user_id: Int,
    val event_id: Int
)

fun EventDto.toDomain(): Event {
    return Event(id, title, description, date, location, category)
}