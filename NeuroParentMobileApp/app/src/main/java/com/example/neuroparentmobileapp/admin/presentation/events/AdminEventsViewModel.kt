package com.example.neuroparentmobileapp.admin.presentation.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.admin.domain.usecase.Resource.Resource
import com.example.neuroparentmobileapp.domain.model.AdminEvent
import com.example.neuroparentmobileapp.domain.usecase.CreateEventUseCase
import com.example.neuroparentmobileapp.domain.usecase.UpdateEventUseCase
import com.example.neuroparentmobileapp.domain.usecase.DeleteEventUseCase
import com.example.neuroparentmobileapp.domain.usecase.GetAdminEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//sealed class Resource<out T> {
//    data class Success<T>(val data: T): Resource<T>()
//    data class Error(val message: String): Resource<Nothing>()
//    object Loading : Resource<Nothing>()
//}

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

    fun fetchAllEvents(token: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = getAdminEventsUseCase(token)) {
                is Resource.Success -> _uiState.value = _uiState.value.copy(isLoading = false, events = result.data)
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }
    fun fetchEventsByAdmin(adminId: Int, token: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = getAdminEventsUseCase.byAdmin(adminId, token)) {
                is Resource.Success -> _uiState.value = _uiState.value.copy(isLoading = false, events = result.data)
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }

    fun createEvent(event: AdminEvent, adminId: Int, token: String) {
        if (event.name.isBlank() || event.description.isBlank() || event.date.isBlank() || event.location.isBlank()) {
            _uiState.value = _uiState.value.copy(error = "All fields are required")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            when (val result = createEventUseCase(event, token)) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Event created successfully")
                    fetchEventsByAdmin(adminId, token)
                }
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }

    fun updateEvent(id: Int, event: AdminEvent, adminId: Int, token: String) {
        if (event.name.isBlank() || event.description.isBlank() || event.date.isBlank() || event.location.isBlank()) {
            _uiState.value = _uiState.value.copy(error = "All fields are required")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            when (val result = updateEventUseCase(id, event, token)) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Event updated successfully")
                    fetchEventsByAdmin(adminId, token)
                }
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }

    fun deleteEvent(id: Int, adminId: Int, token: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            when (val result = deleteEventUseCase(id, token)) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Event deleted successfully")
                    fetchEventsByAdmin(adminId, token)
                }
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }
}