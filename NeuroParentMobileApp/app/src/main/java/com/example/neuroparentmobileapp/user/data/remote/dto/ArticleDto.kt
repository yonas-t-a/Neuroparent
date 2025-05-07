package com.example.neuroparentmobileapp.user.data.remote.dto


import com.example.neuroparentmobileapp.user.domain.model.Article

data class ArticleDto(
    val id: Int,
    val title: String,
    val content: String,
    val category: String,
    val imageUrl: String
)

// Extension function to map ArticleDto to Article domain model
fun ArticleDto.toDomain(): Article {
    return Article(
        id = id,
        title = title,
        content = content,
        category = category,
        imageUrl = imageUrl
    )
}