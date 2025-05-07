package com.example.neuroparentmobileapp.user.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.neuroparentmobileapp.user.domain.model.Event

@Dao
interface EventDao {
    @Query("SELECT * FROM events")
    suspend fun getAllEvents(): List<Event>

    @Insert
    suspend fun saveEvent(event: Event)

    @Update
    suspend fun updateEvent(event: Event)

    @Query("DELETE FROM events WHERE id = :id")
    suspend fun deleteEvent(id: Int)
}