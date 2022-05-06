package com.matheus.casesportheca.feature.world_cup.data.remote.data_source

import com.matheus.casesportheca.feature.world_cup.data.remote.model.BarsResponse
import com.matheus.casesportheca.feature.world_cup.data.remote.model.ScoreResponse
import com.matheus.casesportheca.feature.world_cup.data.remote.model.WorldCupResponse
import com.matheus.casesportheca.feature.world_cup.data.remote.service.WorldCupService
import com.matheus.casesportheca.feature.world_cup.domain.model.Bars
import com.matheus.casesportheca.feature.world_cup.domain.model.Player
import com.matheus.casesportheca.feature.world_cup.domain.model.Score
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class WorldCupRemoteDataSource(private val service: WorldCupService) {
    fun getPlayer(): Flow<Player> = flow {
        emit(service.getWorldCup().toDomain())
    }

    private fun WorldCupResponse.toDomain(): Player =
        objectResponse?.map {
            Player(
                img = it.player?.img.orEmpty(),
                name = it.player?.name.orEmpty(),
                percentage = it.player?.percentage ?: 0.0,
                position = it.player?.position.orEmpty(),
                country = it.player?.country.orEmpty(),
                bars = it.player?.bars?.toDomain() ?: Bars()
            )
        }?.first() ?: Player()


    private fun BarsResponse.toDomain() = Bars(
        worldCupsWon = worldCupsWon?.toDomain() ?: Score(),
        worldCupsParticipated = worldCupsParticipated?.toDomain() ?: Score()
    )

    private fun ScoreResponse.toDomain() = Score(
        max = max ?: 0.0,
        proportional = proportional ?: 0.0,
        place = place ?: 0,
    )
}