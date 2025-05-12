package com.example.neuroparentmobileapp.admin.data.dto

data class EventDto(
    val event_id: Int? = null,
    val event_title: String,
    val event_description: String,
    val event_date: String,
    val event_time: String,
    val event_location: String,
    val event_category: String,
    val creator_id: Int? = null,
    val event_status: Int? = null
)
