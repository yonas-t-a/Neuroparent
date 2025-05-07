package com.example.neuroparentmobileapp.user.domain.usecase


import com.example.neuroparentmobileapp.user.data.remote.dto.ArticleDto
import com.example.neuroparentmobileapp.user.domain.model.Article
import com.example.neuroparentmobileapp.user.domain.repository.ArticleRepository

class GetArticlesUseCase(private val repository: ArticleRepository) {
    suspend operator fun invoke(): List<ArticleDto> {
        return repository.getArticles()
    }
}