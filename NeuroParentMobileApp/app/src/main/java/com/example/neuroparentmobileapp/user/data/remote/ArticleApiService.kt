package com.example.neuroparentmobileapp.user.data.remote



import com.example.neuroparentmobileapp.user.data.remote.dto.ArticleDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleApiService {

    @GET("articles")
    suspend fun getArticles(): List<ArticleDto>

    @GET("articles/{id}")
    suspend fun getArticleById(@Path("id") id: String): ArticleDto

    @GET("articles/category/{category}")
    suspend fun getArticlesByCategory(@Path("category") category: String): List<ArticleDto>
}
