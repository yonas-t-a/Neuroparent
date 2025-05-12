package com.example.neuroparentmobileapp.admin.domin.entity

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val time: String,
    val location: String,
    val category: String,
    val creatorId: Int,
    val status: Boolean
)






