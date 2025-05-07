package com.example.neuroparentmobileapp.user.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.neuroparentmobileapp.user.domain.model.UserProfile

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUserProfile(id: Int): UserProfile?

    @Insert
    suspend fun saveUserProfile(userProfile: UserProfile)

    @Update
    suspend fun updateUserProfile(userProfile: UserProfile)
}