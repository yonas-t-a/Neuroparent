package com.example.neuroparentmobileapp.admin.domin.usercase

import com.example.neuroparentmobileapp.admin.domin.repository.AdminEventRepository

class GetEventsByCreatorUseCase(private val repo: AdminEventRepository) {
    suspend operator fun invoke(creatorId: Int) = repo.getEventsByCreator(creatorId)
}
