package com.example.neuroparentmobileapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class AdminEvent(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val description: String,
    val date: String,
    val location: String
)