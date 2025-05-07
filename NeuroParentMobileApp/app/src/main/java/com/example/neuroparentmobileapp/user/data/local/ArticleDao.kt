package com.example.neuroparentmobileapp.user.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.neuroparentmobileapp.user.domain.model.Article

@Dao
interface ArticleDao {
    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<Article>

    @Insert
    suspend fun saveArticle(article: Article)

    @Update
    suspend fun updateArticle(article: Article)

    @Query("DELETE FROM articles WHERE id = :id")
    suspend fun deleteArticle(id: Int)
}