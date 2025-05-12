package com.example.neuroparentmobileapp.auth.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class User(
    val name: String,
    val email: String,
    val role: String = "user"
)

