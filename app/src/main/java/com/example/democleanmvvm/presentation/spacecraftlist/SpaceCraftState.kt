package com.example.democleanmvvm.presentation.spacecraftlist

import com.example.democleanmvvm.domain.model.Craft

data class SpaceCraftState(  val isLoading:Boolean=false,
                             val error:String="",
                             val data:List<Craft>?=null)
