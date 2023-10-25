package com.example.democleanmvvm.data.network

import com.example.democleanmvvm.data.model.CraftDTO
import retrofit2.http.GET

interface ApiService {

    @GET("/api/spacecrafts")
    suspend fun getSpaceCraftList() : List<CraftDTO>
}