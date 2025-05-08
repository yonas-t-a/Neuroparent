package com.example.neuroparentmobileapp.user.domain.repository

import com.example.neuroparentmobileapp.user.domain.model.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
}