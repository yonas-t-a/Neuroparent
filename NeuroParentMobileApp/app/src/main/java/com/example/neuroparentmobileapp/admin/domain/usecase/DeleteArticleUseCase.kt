package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.repository.AdminArticleRepository

sealed class Resource<out T> {
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

class DeleteArticleUseCase(private val repository: AdminArticleRepository) {
    suspend operator fun invoke(articleId: Int, token: String): Resource<Unit> {
        return try {
            repository.deleteArticle(articleId, token)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}