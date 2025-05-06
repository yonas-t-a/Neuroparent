package com.example.neuroparentmobileapp.admin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.neuroparentmobileapp.domain.model.AdminArticle

@Dao
interface AdminArticleDao {
    @Query("SELECT * FROM articles WHERE id = :id")
    suspend fun getArticleById(id: Int): AdminArticle?

    @Insert
    suspend fun createArticle(article: AdminArticle)

    @Update
    suspend fun updateArticle(article: AdminArticle)

    @Query("DELETE FROM articles WHERE id = :id")
    suspend fun deleteArticle(id: Int)
}