package com.example.neuroparentmobileapp.user.data.repository


import com.example.neuroparentmobileapp.user.data.remote.ArticleApiService
import com.example.neuroparentmobileapp.user.data.remote.dto.ArticleDto
import com.example.neuroparentmobileapp.user.domain.repository.ArticleRepository

class ArticleRepositoryImpl(private val apiService: ArticleApiService) : ArticleRepository {
     override suspend fun getArticles(): List<ArticleDto> {
         return apiService.getArticles()
     }
//    override suspend fun getArticles(): List<ArticleDto> {
//        return apiService.getArticles().map { it.toDomain() }
//    }
}