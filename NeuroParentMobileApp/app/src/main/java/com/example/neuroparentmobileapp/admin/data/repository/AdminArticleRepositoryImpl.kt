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
package com.example.neuroparentmobileapp.data.repository

import com.example.neuroparentmobileapp.data.remote.AdminArticleApiService
import com.example.neuroparentmobileapp.domain.model.AdminArticle
import com.example.neuroparentmobileapp.domain.repository.AdminArticleRepository

class AdminArticleRepositoryImpl(
    private val apiService: AdminArticleApiService
) : AdminArticleRepository {
    override suspend fun createArticle(article: AdminArticle) {
        apiService.createArticle(article)
    }

    override suspend fun updateArticle(id: Int, article: AdminArticle) {
        apiService.updateArticle(id, article)
    }

    override suspend fun deleteArticle(id: Int) {
        apiService.deleteArticle(id)
    }
}