package com.example.neuroparentmobileapp.admin.data.remote.dto

import com.example.neuroparentmobileapp.admin.domain.model.AdminArticle

// Matches backend API response
// { article_id, article_title, article_content, article_image, article_category, article_creator_id }
data class AdminArticleDto(
    val article_id: Int,
    val article_title: String,
    val article_content: String,
    val article_image: String?,
    val article_category: String,
    val article_creator_id: Int
)

fun AdminArticleDto.toDomain(): AdminArticle = AdminArticle(
    id = article_id,
    title = article_title,
    content = article_content,
    category = article_category,
    imageUrl = article_image
)

fun AdminArticle.toDto(adminId: Int): AdminArticleDto = AdminArticleDto(
    article_id = id ?: 0,
    article_title = title,
    article_content = content,
    article_image = imageUrl,
    article_category = category,
    article_creator_id = adminId
) 