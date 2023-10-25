package com.example.democleanmvvm.data.di

import com.example.democleanmvvm.data.network.ApiService
import com.example.democleanmvvm.data.repository.SpaceCraftsRepoImpl
import com.example.democleanmvvm.domain.repository.SpaceCraftsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("https://isro.vercel.app").addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit) : ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideSpaceCraftRepo(apiService: ApiService): SpaceCraftsRepo{
        return SpaceCraftsRepoImpl(apiService)
    }
}