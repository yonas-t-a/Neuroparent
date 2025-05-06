package com.example.neuroparentmobileapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class AdminArticle(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val title: String,
    val content: String,
    val category: String,
    val imageUrl: String? = null
)