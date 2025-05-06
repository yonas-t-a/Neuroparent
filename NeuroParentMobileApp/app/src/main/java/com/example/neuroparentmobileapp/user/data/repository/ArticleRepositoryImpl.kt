package com.example.neuroparentmobileapp.data.repository

import com.example.neuroparentmobileapp.data.remote.ArticleApiService
import com.example.neuroparentmobileapp.domain.model.Article
import com.example.neuroparentmobileapp.domain.repository.ArticleRepository

class ArticleRepositoryImpl(private val apiService: ArticleApiService) : ArticleRepository {
    override suspend fun getArticles(): List<Article> {
        return apiService.getArticles()
    }

    override suspend fun bookmarkArticle(id: Int) {
        apiService.bookmarkArticle(id)
    }
}