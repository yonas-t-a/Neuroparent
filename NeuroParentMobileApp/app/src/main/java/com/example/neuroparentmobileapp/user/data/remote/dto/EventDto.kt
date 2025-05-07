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

fun EventDto.toDomain(): Event {
    return Event(id, title,description,date,location,category)
}