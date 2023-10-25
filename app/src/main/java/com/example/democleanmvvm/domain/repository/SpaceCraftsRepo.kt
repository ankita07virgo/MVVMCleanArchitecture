package com.example.democleanmvvm.domain.repository

import com.example.democleanmvvm.domain.model.Craft

interface SpaceCraftsRepo {
    suspend fun getSpaceCraftsList() : List<Craft>
}