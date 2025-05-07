package com.example.neuroparentmobileapp.domain.usecase

import com.example.neuroparentmobileapp.domain.repository.AdminEventRepository

sealed class Resource<out T> {
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

class DeleteEventUseCase(private val repository: AdminEventRepository) {
    suspend operator fun invoke(eventId: Int, token: String): Resource<Unit> {
        return try {
            repository.deleteEvent(eventId, token)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}