package com.matheus.casesportheca.feature.world_cup.data.remote.model

import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("img")
    val img: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("percentual")
    val percentage: Double? = null,
    @SerializedName("pos")
    val position: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("Barras")
    val bars: BarsResponse? = null
)
