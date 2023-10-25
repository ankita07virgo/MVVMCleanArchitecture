package com.example.democleanmvvm.domain.di

import com.example.democleanmvvm.domain.repository.SpaceCraftsRepo
import com.example.democleanmvvm.domain.use_cases.GetSpaceCraftListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    fun providGetSpaceCraftListUseCase(spaceCraftsRepo: SpaceCraftsRepo) : GetSpaceCraftListUseCase{
        return GetSpaceCraftListUseCase(spaceCraftsRepo)
    }
}