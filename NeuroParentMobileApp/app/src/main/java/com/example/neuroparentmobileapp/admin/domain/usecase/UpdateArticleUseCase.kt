package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.AdminArticle
import com.example.neuroparentmobileapp.domain.repository.AdminArticleRepository

class UpdateArticleUseCase(private val repository: AdminArticleRepository) {
    suspend operator fun invoke(id: Int, article: AdminArticle) {
        repository.updateArticle(id, article)
    }
}