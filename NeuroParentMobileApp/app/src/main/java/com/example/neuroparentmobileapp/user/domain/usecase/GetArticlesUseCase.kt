package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.Article
import com.example.neuroparentmobileapp.domain.repository.ArticleRepository

class GetArticlesUseCase(private val repository: ArticleRepository) {
    suspend operator fun invoke(): List<Article> {
        return repository.getArticles()
    }
}