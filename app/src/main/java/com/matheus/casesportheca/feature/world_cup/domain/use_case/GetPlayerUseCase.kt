package com.matheus.casesportheca.feature.world_cup.domain.use_case

import com.matheus.casesportheca.feature.world_cup.domain.model.Player
import com.matheus.casesportheca.feature.world_cup.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow

class GetPlayerUseCase(private val repository: WorldCupRepository) {
    operator fun invoke(): Flow<Player> = repository.getPlayer()
}