package com.example.democleanmvvm.common

import com.example.democleanmvvm.data.model.CraftDTO
import com.example.democleanmvvm.data.model.SpaceCraftsDTO
import com.example.democleanmvvm.domain.model.Craft
import com.example.democleanmvvm.domain.model.SpaceCrafts

fun SpaceCraftsDTO.toDomain(): SpaceCrafts {
    return SpaceCrafts(crafts = craftsDTO?.map{it.toDomain()}?: emptyList())
}

fun CraftDTO.toDomain(): Craft {
    return Craft(id = id?:0,name = name?:"")
}
