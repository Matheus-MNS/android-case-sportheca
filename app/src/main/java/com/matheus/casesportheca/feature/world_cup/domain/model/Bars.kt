package com.matheus.casesportheca.feature.world_cup.domain.model

data class Bars(
    val worldCupsWon: Score = Score(),
    val worldCupsParticipated: Score = Score()
)
