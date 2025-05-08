package com.example.neuroparentmobileapp.user.data.repository

import com.example.neuroparentmobileapp.user.data.remote.ArticleApiService
import com.example.neuroparentmobileapp.user.data.remote.dto.toDomain
import com.example.neuroparentmobileapp.user.domain.model.Article
import com.example.neuroparentmobileapp.user.domain.repository.ArticleRepository

class ArticleRepositoryImpl(private val apiService: ArticleApiService) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return apiService.getArticles().map { it.toDomain() }
     }
}