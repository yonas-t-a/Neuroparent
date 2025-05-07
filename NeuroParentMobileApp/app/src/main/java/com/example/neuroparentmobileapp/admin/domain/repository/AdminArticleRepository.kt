package com.example.neuroparentmobileapp.domain.repository

import com.example.neuroparentmobileapp.domain.model.AdminArticle

interface AdminArticleRepository {
    suspend fun createArticle(article: AdminArticle, token: String, image: ByteArray?)
    suspend fun updateArticle(id: Int, article: AdminArticle, token: String, image: ByteArray?)
    suspend fun deleteArticle(id: Int, token: String)
    suspend fun getAllArticles(token: String): List<AdminArticle>
    suspend fun getArticlesByAdmin(adminId: Int, token: String): List<AdminArticle>
}