package com.example.neuroparentmobileapp.admin.presentation.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.domain.model.AdminEvent
import com.example.neuroparentmobileapp.domain.usecase.CreateEventUseCase
import com.example.neuroparentmobileapp.domain.usecase.UpdateEventUseCase
import com.example.neuroparentmobileapp.domain.usecase.DeleteEventUseCase
import com.example.neuroparentmobileapp.domain.usecase.GetAdminEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class Resource<out T> {
    data class Success<T>(val data: T): Resource<T>()
    data class Error(val message: String): Resource<Nothing>()
    object Loading : Resource<Nothing>()
}

data class AdminEventsUiState(
    val events: List<AdminEvent> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null
)

class AdminEventsViewModel(
    private val createEventUseCase: CreateEventUseCase,
    private val updateEventUseCase: UpdateEventUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
    private val getAdminEventsUseCase: GetAdminEventsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(AdminEventsUiState())
    val uiState: StateFlow<AdminEventsUiState> = _uiState

    fun fetchAllEvents() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val events = getAdminEventsUseCase()
                _uiState.value = _uiState.value.copy(isLoading = false, events = events)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }
    fun fetchEventsByAdmin(adminId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val events = getAdminEventsUseCase.byAdmin(adminId)
                _uiState.value = _uiState.value.copy(isLoading = false, events = events)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    fun createEvent(event: AdminEvent, adminId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            try {
                createEventUseCase(event)
                _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Event created successfully")
                fetchEventsByAdmin(adminId)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    fun updateEvent(id: Int, event: AdminEvent, adminId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            try {
                updateEventUseCase(id, event)
                _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Event updated successfully")
                fetchEventsByAdmin(adminId)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }

    fun deleteEvent(id: Int, adminId: Int) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            try {
                deleteEventUseCase(id)
                _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Event deleted successfully")
                fetchEventsByAdmin(adminId)
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = e.message)
            }
        }
    }
}