package com.example.neuroparentmobileapp.admin.domain.usecase

import com.example.neuroparentmobileapp.admin.domain.model.AdminArticle
import com.example.neuroparentmobileapp.admin.domain.repository.AdminArticleRepository
import com.example.neuroparentmobileapp.admin.domain.usecase.resource.Resource

//sealed class Resource<out T> {
//    data class Success<T>(val data: T): Resource<T>()
//    data class Error(val message: String): Resource<Nothing>()
//    object Loading : Resource<Nothing>()
//}

class GetAdminArticlesUseCase(private val repository: AdminArticleRepository) {
    suspend operator fun invoke(token: String): Resource<List<AdminArticle>> {
        return try {
            Resource.Success(repository.getAllArticles(token))
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
    suspend fun byAdmin(adminId: Int, token: String): Resource<List<AdminArticle>> {
        return try {
            Resource.Success(repository.getArticlesByAdmin(adminId, token))
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
} 