package com.example.neuroparentmobileapp.domain.repository

import com.example.neuroparentmobileapp.domain.model.AdminArticle

interface AdminArticleRepository {
    suspend fun createArticle(article: AdminArticle)
    suspend fun updateArticle(id: Int, article: AdminArticle)
    suspend fun deleteArticle(id: Int)
}