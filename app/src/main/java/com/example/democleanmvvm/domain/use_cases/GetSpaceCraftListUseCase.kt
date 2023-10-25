package com.example.democleanmvvm.domain.use_cases

import com.example.democleanmvvm.common.Resource
import com.example.democleanmvvm.domain.model.Craft
import com.example.democleanmvvm.domain.model.SpaceCrafts
import com.example.democleanmvvm.domain.repository.SpaceCraftsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetSpaceCraftListUseCase (private val spaceCraftsRepo: SpaceCraftsRepo){

operator fun invoke(): Flow<Resource<List<Craft>>> = flow {
    emit(Resource.Loading())
    try {
        emit(Resource.Success(data= spaceCraftsRepo.getSpaceCraftsList()))
    }
    catch (e: Exception){
        emit(Resource.Error(message = e.message.toString()))
    }
}.flowOn(Dispatchers.IO)
}