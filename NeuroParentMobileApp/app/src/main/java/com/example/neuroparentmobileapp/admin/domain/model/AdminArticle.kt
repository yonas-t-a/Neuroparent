package com.example.neuroparentmobileapp.domain.model

data class AdminArticle(
    val id: Int? = null,
    val title: String,
    val content: String,
    val category: String,
    val imageUrl: String? = null
)