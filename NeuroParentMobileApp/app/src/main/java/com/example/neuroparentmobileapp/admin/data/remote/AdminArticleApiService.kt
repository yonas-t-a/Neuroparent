// package com.example.neuroparentmobileapp.admin.data.remote

// import admin.data.remote.dto.ArticleDto
// import okhttp3.MultipartBody
// import okhttp3.RequestBody
// import retrofit2.http.*

// interface AdminArticleApiService {

//     @Multipart
//     @POST("articles")
//     suspend fun createArticle(
//         @Part("title") title: RequestBody,
//         @Part("content") content: RequestBody,
//         @Part("category") category: RequestBody,
//         @Part img: MultipartBody.Part?
//     ): ArticleDto

//     @Multipart
//     @PUT("articles/{id}")
//     suspend fun updateArticle(
//         @Path("id") id: String,
//         @Part("title") title: RequestBody,
//         @Part("content") content: RequestBody,
//         @Part("category") category: RequestBody,
//         @Part img: MultipartBody.Part?
//     ): ArticleDto

//     @DELETE("articles/{id}")
//     suspend fun deleteArticle(@Path("id") id: String)
// }
package com.example.neuroparentmobileapp.admin.data.remote

import com.example.neuroparentmobileapp.domain.model.AdminArticle
import retrofit2.http.*

interface AdminArticleApiService {
    @POST("articles")
    suspend fun createArticle(@Body article: AdminArticle)

    @PUT("articles/{id}")
    suspend fun updateArticle(@Path("id") id: Int, @Body article: AdminArticle)

    @DELETE("articles/{id}")
    suspend fun deleteArticle(@Path("id") id: Int)
}