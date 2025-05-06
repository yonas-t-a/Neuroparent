package com.example.neuroparentmobileapp.domain.repository

import com.example.neuroparentmobileapp.domain.model.Article

interface ArticleRepository {
    suspend fun getArticles(): List<Article>
    suspend fun bookmarkArticle(articleId: Int)
}