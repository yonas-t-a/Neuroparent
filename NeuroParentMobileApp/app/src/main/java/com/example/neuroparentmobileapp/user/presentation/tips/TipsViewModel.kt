package com.example.neuroparentmobileapp.user.presentation.tips

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.user.domain.model.Article
import com.example.neuroparentmobileapp.user.domain.usecase.GetArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class TipsUiState {
    object Loading : TipsUiState()
    data class Success(val articles: List<Article>) : TipsUiState()
    data class Error(val message: String) : TipsUiState()
}

class TipsViewModel(
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<TipsUiState>(TipsUiState.Loading)
    val uiState: StateFlow<TipsUiState> = _uiState

    private var allArticles: List<Article> = emptyList()
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery
    private val _categoryFilter = MutableStateFlow<String?>(null)
    val categoryFilter: StateFlow<String?> = _categoryFilter

    init {
        fetchTips()
    }

    fun fetchTips() {
        _uiState.value = TipsUiState.Loading
        viewModelScope.launch {
            try {
                allArticles = getArticlesUseCase()
                applyFilters()
            } catch (e: Exception) {
                _uiState.value = TipsUiState.Error(e.message ?: "Failed to load tips")
            }
        }
    }

    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query
        applyFilters()
    }

    fun onCategoryFilterChange(category: String?) {
        _categoryFilter.value = category
        applyFilters()
    }

    private fun applyFilters() {
        val query = _searchQuery.value.trim().lowercase()
        val category = _categoryFilter.value
        var filtered = allArticles
        if (query.isNotEmpty()) {
            filtered = filtered.filter {
                it.title.contains(query, ignoreCase = true) ||
                it.content.contains(query, ignoreCase = true)
            }
        }
        if (!category.isNullOrEmpty()) {
            filtered = filtered.filter { it.category.equals(category, ignoreCase = true) }
        }
        _uiState.value = TipsUiState.Success(filtered)
    }
}
