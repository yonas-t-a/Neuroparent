package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.model.AdminEvent
import com.example.neuroparentmobileapp.domain.repository.AdminEventRepository

sealed class Resource<out T> {
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

class GetAdminEventsUseCase(private val repository: AdminEventRepository) {
    suspend operator fun invoke(token: String): Resource<List<AdminEvent>> {
        return try {
            Resource.Success(repository.getAllEvents(token))
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
    suspend fun byAdmin(adminId: Int, token: String): Resource<List<AdminEvent>> {
        return try {
            Resource.Success(repository.getEventsByAdmin(adminId, token))
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
} 