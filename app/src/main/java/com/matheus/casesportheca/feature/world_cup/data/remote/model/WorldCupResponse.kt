package com.matheus.casesportheca.feature.world_cup.data.remote.model

import com.google.gson.annotations.SerializedName

data class WorldCupResponse(
    @SerializedName("Object")
    val objectResponse: List<ObjectResponse>? = null
)
