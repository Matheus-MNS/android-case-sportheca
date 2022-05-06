package com.matheus.casesportheca.feature.world_cup.data.remote.model

import com.google.gson.annotations.SerializedName

data class ScoreResponse(
    @SerializedName("max")
    val max: Double? = null,
    @SerializedName("pla")
    val proportional: Double? = null,
    @SerializedName("pos")
    val place: Int? = null
)
