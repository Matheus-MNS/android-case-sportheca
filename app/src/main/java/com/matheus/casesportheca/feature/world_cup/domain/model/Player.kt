package com.matheus.casesportheca.feature.world_cup.domain.model

data class Player(
    val img: String = "",
    val name: String = "",
    val percentage: Double = 0.0,
    val position: String = "",
    val country: String = "",
    val bars: Bars = Bars()
)
