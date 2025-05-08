package com.example.neuroparentmobileapp.user.presentation.events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.user.domain.model.Event
import com.example.neuroparentmobileapp.user.domain.usecase.GetEventsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class EventsUiState {
    object Loading : EventsUiState()
    data class Success(val events: List<Event>) : EventsUiState()
    data class Error(val message: String) : EventsUiState()
}

class EventsViewModel(
    private val getEventsUseCase: GetEventsUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<EventsUiState>(EventsUiState.Loading)
    val uiState: StateFlow<EventsUiState> = _uiState

    init {
        fetchEvents()
    }

    fun fetchEvents() {
        _uiState.value = EventsUiState.Loading
        viewModelScope.launch {
            try {
                val events = getEventsUseCase()
                _uiState.value = EventsUiState.Success(events)
            } catch (e: Exception) {
                _uiState.value = EventsUiState.Error(e.message ?: "Failed to load events")
            }
        }
    }
}
