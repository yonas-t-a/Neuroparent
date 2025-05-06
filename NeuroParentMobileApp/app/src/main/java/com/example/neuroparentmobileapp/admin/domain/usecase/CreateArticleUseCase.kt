package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.AdminArticle
import com.example.neuroparentmobileapp.domain.repository.AdminArticleRepository

class CreateArticleUseCase(private val repository: AdminArticleRepository) {
    suspend operator fun invoke(article: AdminArticle) {
        repository.createArticle(article)
    }
}