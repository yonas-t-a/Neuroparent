package com.example.neuroparentmobileapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.neuroparentmobileapp.domain.model.AdminEvent

@Dao
interface AdminEventDao {
    @Query("SELECT * FROM events WHERE id = :id")
    suspend fun getEventById(id: Int): AdminEvent?

    @Insert
    suspend fun createEvent(event: AdminEvent)

    @Update
    suspend fun updateEvent(event: AdminEvent)

    @Query("DELETE FROM events WHERE id = :id")
    suspend fun deleteEvent(id: Int)
}