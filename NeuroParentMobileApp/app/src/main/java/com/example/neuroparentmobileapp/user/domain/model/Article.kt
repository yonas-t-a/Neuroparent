package com.example.neuroparentmobileapp.user.domain.model

data class Article(
    val id: Int,
    val title: String,
    val content: String,
    val category: String,
    val imageUrl: String? = null
)