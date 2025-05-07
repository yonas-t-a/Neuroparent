package com.example.neuroparentmobileapp.auth.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class AuthUser(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val email: String,
    val role: String
)

