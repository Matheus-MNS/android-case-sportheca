package com.matheus.casesportheca.feature.world_cup.data.repository

import com.matheus.casesportheca.feature.world_cup.data.remote.data_source.WorldCupRemoteDataSource
import com.matheus.casesportheca.feature.world_cup.domain.model.Player
import com.matheus.casesportheca.feature.world_cup.domain.repository.WorldCupRepository
import kotlinx.coroutines.flow.Flow

class WorldCupRepositoryImpl(
    private val remoteDataSource: WorldCupRemoteDataSource
) : WorldCupRepository {
    override fun getPlayer(): Flow<Player> = remoteDataSource.getPlayer()
}