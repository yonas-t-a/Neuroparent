
package com.example.neuroparentmobileapp.admin.data.remote

import com.example.neuroparentmobileapp.admin.data.remote.dto.AdminArticleDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface AdminArticleApiService {
    @GET("articles")
    suspend fun getAllArticles(@Header("Authorization") token: String): List<AdminArticleDto>

    @Multipart
    @POST("articles")
    suspend fun createArticle(
        @Header("Authorization") token: String,
        @Part("title") title: RequestBody,
        @Part("content") content: RequestBody,
        @Part("category") category: RequestBody,
        @Part img: MultipartBody.Part?
    ): AdminArticleDto

    @Multipart
    @PUT("articles/{id}")
    suspend fun updateArticle(
        @Header("Authorization") token: String,
        @Path("id") id: Int,
        @Part("title") title: RequestBody,
        @Part("content") content: RequestBody,
        @Part("category") category: RequestBody,
        @Part img: MultipartBody.Part?
    ): AdminArticleDto

    @DELETE("articles/{id}")
    suspend fun deleteArticle(
        @Header("Authorization") token: String,
        @Path("id") id: Int
    )
}