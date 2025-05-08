package com.example.neuroparentmobileapp.admin.presentation.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.neuroparentmobileapp.admin.domain.usecase.Resource.Resource
import com.example.neuroparentmobileapp.domain.model.AdminArticle
import com.example.neuroparentmobileapp.domain.usecase.CreateArticleUseCase
import com.example.neuroparentmobileapp.domain.usecase.UpdateArticleUseCase
import com.example.neuroparentmobileapp.domain.usecase.DeleteArticleUseCase
import com.example.neuroparentmobileapp.domain.usecase.GetAdminArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//sealed class Resource<out T> {
//    data class Success<T>(val data: T): Resource<T>()
//    data class Error(val message: String): Resource<Nothing>()
//    object Loading : Resource<Nothing>()
//}

data class AdminArticlesUiState(
    val articles: List<AdminArticle> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null,
    val successMessage: String? = null
)

class AdminArticlesViewModel(
    private val createArticleUseCase: CreateArticleUseCase,
    private val updateArticleUseCase: UpdateArticleUseCase,
    private val deleteArticleUseCase: DeleteArticleUseCase,
    private val getAdminArticlesUseCase: GetAdminArticlesUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(AdminArticlesUiState())
    val uiState: StateFlow<AdminArticlesUiState> = _uiState

    fun fetchAllArticles(token: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = getAdminArticlesUseCase(token)) {
                is Resource.Success -> _uiState.value = _uiState.value.copy(isLoading = false, articles = result.data)
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }

    fun fetchArticlesByAdmin(adminId: Int, token: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            when (val result = getAdminArticlesUseCase.byAdmin(adminId, token)) {
                is Resource.Success -> _uiState.value = _uiState.value.copy(isLoading = false, articles = result.data)
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }

    fun createArticle(article: AdminArticle, adminId: Int, token: String, image: ByteArray?) {
        if (article.title.isBlank() || article.content.isBlank() || article.category.isBlank()) {
            _uiState.value = _uiState.value.copy(error = "All fields are required")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            when (val result = createArticleUseCase(article, token, image)) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Article created successfully")
                    fetchArticlesByAdmin(adminId, token)
                }
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }

    fun updateArticle(id: Int, article: AdminArticle, adminId: Int, token: String, image: ByteArray?) {
        if (article.title.isBlank() || article.content.isBlank() || article.category.isBlank()) {
            _uiState.value = _uiState.value.copy(error = "All fields are required")
            return
        }
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            when (val result = updateArticleUseCase(id, article, token, image)) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Article updated successfully")
                    fetchArticlesByAdmin(adminId, token)
                }
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }

    fun deleteArticle(id: Int, adminId: Int, token: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null, successMessage = null)
            when (val result = deleteArticleUseCase(id, token)) {
                is Resource.Success -> {
                    _uiState.value = _uiState.value.copy(isLoading = false, successMessage = "Article deleted successfully")
                    fetchArticlesByAdmin(adminId, token)
                }
                is Resource.Error -> _uiState.value = _uiState.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _uiState.value = _uiState.value.copy(isLoading = true)
            }
        }
    }
}
