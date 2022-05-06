package com.matheus.casesportheca.feature.world_cup.data.remote.service

import com.matheus.casesportheca.feature.world_cup.data.remote.model.WorldCupResponse
import retrofit2.http.GET

interface WorldCupService {
    @GET("teste.json")
    suspend fun getWorldCup(): WorldCupResponse
}