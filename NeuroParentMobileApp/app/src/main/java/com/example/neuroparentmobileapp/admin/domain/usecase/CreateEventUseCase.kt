package com.example.neuroparentmobileapp.admin.domain.usecase

import com.example.neuroparentmobileapp.admin.domain.model.AdminEvent
import com.example.neuroparentmobileapp.admin.domain.repository.AdminEventRepository
import com.example.neuroparentmobileapp.admin.domain.usecase.resource.Resource

//sealed class Resource<out T> {
//    data class Success<T>(val data: T): Resource<T>()
//    data class Error(val message: String): Resource<Nothing>()
//    object Loading : Resource<Nothing>()
//}

class CreateEventUseCase(private val repository: AdminEventRepository) {
    suspend operator fun invoke(event: AdminEvent, token: String): Resource<Unit> {
        return try {
            repository.createEvent(event, token)
            Resource.Success(Unit)
        } catch (e: Exception) {
            Resource.Error(e.message ?: "Unknown error")
        }
    }
}