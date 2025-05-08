package com.example.neuroparentmobileapp.user.domain.usecase

import com.example.neuroparentmobileapp.user.domain.model.Article
import com.example.neuroparentmobileapp.user.domain.repository.ArticleRepository

class GetArticlesUseCase(private val repository: ArticleRepository) {
    suspend operator fun invoke(): List<Article> {
        return repository.getArticles()
    }
}