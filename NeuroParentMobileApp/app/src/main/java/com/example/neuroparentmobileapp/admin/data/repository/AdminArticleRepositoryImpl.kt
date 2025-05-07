// package com.example.neuroparentmobileapp.data.repository

// import com.example.neuroparentmobileapp.data.remote.AdminArticleApiService
// import com.example.neuroparentmobileapp.domain.model.AdminArticle
// import com.example.neuroparentmobileapp.domain.repository.AdminArticleRepository

// class AdminArticleRepositoryImpl(
//     private val apiService: AdminArticleApiService
// ) : AdminArticleRepository {
//     override suspend fun createArticle(article: AdminArticle) {
//         apiService.createArticle(article)
//     }

//     override suspend fun updateArticle(id: Int, article: AdminArticle) {
//         apiService.updateArticle(id, article)
//     }

//     override suspend fun deleteArticle(id: Int) {
//         apiService.deleteArticle(id)
//     }
// }
package com.example.neuroparentmobileapp.admin.data.repository

import com.example.neuroparentmobileapp.admin.data.remote.AdminArticleApiService
import com.example.neuroparentmobileapp.admin.data.remote.dto.AdminArticleDto
import com.example.neuroparentmobileapp.admin.data.remote.dto.toDomain
import com.example.neuroparentmobileapp.domain.model.AdminArticle
import com.example.neuroparentmobileapp.domain.repository.AdminArticleRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody

class AdminArticleRepositoryImpl(
    private val apiService: AdminArticleApiService
) : AdminArticleRepository {
    override suspend fun createArticle(article: AdminArticle, token: String, image: ByteArray?) {
        val title = RequestBody.create("text/plain".toMediaTypeOrNull(), article.title)
        val content = RequestBody.create("text/plain".toMediaTypeOrNull(), article.content)
        val category = RequestBody.create("text/plain".toMediaTypeOrNull(), article.category)
        val imgPart = image?.let {
            MultipartBody.Part.createFormData(
                "img", "image.jpg", RequestBody.create("image/*".toMediaTypeOrNull(), it)
            )
        }
        apiService.createArticle(token, title, content, category, imgPart)
    }

    override suspend fun updateArticle(id: Int, article: AdminArticle, token: String, image: ByteArray?) {
        val title = RequestBody.create("text/plain".toMediaTypeOrNull(), article.title)
        val content = RequestBody.create("text/plain".toMediaTypeOrNull(), article.content)
        val category = RequestBody.create("text/plain".toMediaTypeOrNull(), article.category)
        val imgPart = image?.let {
            MultipartBody.Part.createFormData(
                "img", "image.jpg", RequestBody.create("image/*".toMediaTypeOrNull(), it)
            )
        }
        apiService.updateArticle(token, id, title, content, category, imgPart)
    }

    override suspend fun deleteArticle(id: Int, token: String) {
        apiService.deleteArticle(token, id)
    }

    override suspend fun getAllArticles(token: String): List<AdminArticle> {
        return apiService.getAllArticles(token).map(AdminArticleDto::toDomain)
    }

    override suspend fun getArticlesByAdmin(adminId: Int, token: String): List<AdminArticle> {
        return apiService.getAllArticles(token)
            .filter { it.article_creator_id == adminId }
            .map(AdminArticleDto::toDomain)
    }
}