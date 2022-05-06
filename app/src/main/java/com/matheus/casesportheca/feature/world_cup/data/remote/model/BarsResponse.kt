package com.matheus.casesportheca.feature.world_cup.data.remote.model

import com.google.gson.annotations.SerializedName

data class BarsResponse(
    @SerializedName("Copas_do_Mundo_Vencidas")
    val worldCupsWon: ScoreResponse? = null,
    @SerializedName("Copas_do_Mundo_Disputadas")
    val worldCupsParticipated: ScoreResponse? = null
)
