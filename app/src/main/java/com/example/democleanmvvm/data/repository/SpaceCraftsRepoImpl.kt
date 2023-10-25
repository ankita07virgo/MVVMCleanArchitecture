package com.example.democleanmvvm.data.repository

import com.example.democleanmvvm.common.toDomain
import com.example.democleanmvvm.data.network.ApiService
import com.example.democleanmvvm.domain.model.Craft
import com.example.democleanmvvm.domain.repository.SpaceCraftsRepo

class SpaceCraftsRepoImpl(private val apiService: ApiService): SpaceCraftsRepo {
    override suspend fun getSpaceCraftsList(): List<Craft> {
        return apiService.getSpaceCraftList().map { it.toDomain() }
    }
}