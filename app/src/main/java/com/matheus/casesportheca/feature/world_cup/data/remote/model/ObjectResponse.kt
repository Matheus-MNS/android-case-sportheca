package com.matheus.casesportheca.feature.world_cup.data.remote.model

import com.google.gson.annotations.SerializedName

data class ObjectResponse(
    @SerializedName("Player")
    val player: PlayerResponse? = null
)
