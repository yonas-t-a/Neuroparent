package com.example.neuroparentmobileapp.domain.model

data class AdminEvent(
    val id: Int? = null,
    val name: String,
    val description: String,
    val date: String,
    val location: String
)