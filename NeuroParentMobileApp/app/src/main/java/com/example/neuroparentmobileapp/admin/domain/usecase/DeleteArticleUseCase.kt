package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.repository.AdminArticleRepository

class DeleteArticleUseCase(private val repository: AdminArticleRepository) {
    suspend operator fun invoke(articleId: Int) {
        repository.deleteArticle(articleId)
    }
}