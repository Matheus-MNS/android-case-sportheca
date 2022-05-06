package com.matheus.casesportheca.feature.world_cup.domain.repository

import com.matheus.casesportheca.feature.world_cup.domain.model.Player
import kotlinx.coroutines.flow.Flow

interface WorldCupRepository {

    fun getPlayer(): Flow<Player>
}