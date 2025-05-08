package com.example.neuroparentmobileapp.admin.domain.usecase

import com.example.neuroparentmobileapp.admin.domain.model.AdminArticle
import com.example.neuroparentmobileapp.admin.domain.repository.AdminArticleRepository
import com.example.neuroparentmobileapp.admin.domain.usecase.resource.Resource

//sealed class Resource<out T> {
//    data class Success<T>(val data: T): Resource<T>()
//    data class Error(val message: String): Resource<Nothing>()
//    object Loading : Resource<Nothing>()
//}

class UpdateArticleUseCase(private val repository: AdminArticleRepository) {
    suspend operator fun invoke(id: Int, article: AdminArticle, token: String, image: ByteArray?): Resource<Unit> {
        return try {
            repository.updateArticle(id, article, token, image)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}