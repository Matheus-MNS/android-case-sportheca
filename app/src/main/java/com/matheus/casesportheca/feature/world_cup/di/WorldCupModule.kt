package com.matheus.casesportheca.feature.world_cup.di

import com.matheus.casesportheca.feature.world_cup.data.remote.data_source.WorldCupRemoteDataSource
import com.matheus.casesportheca.feature.world_cup.data.remote.service.WorldCupService
import com.matheus.casesportheca.feature.world_cup.data.repository.WorldCupRepositoryImpl
import com.matheus.casesportheca.feature.world_cup.domain.use_case.GetPlayerUseCase
import com.matheus.casesportheca.feature.world_cup.presentation.WorldCupViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val worldCupModule = module {

    viewModel {
        WorldCupViewModel(
            getPlayerUseCase = GetPlayerUseCase(
                repository = WorldCupRepositoryImpl(
                    remoteDataSource = WorldCupRemoteDataSource(
                        service = get<Retrofit>().create(WorldCupService::class.java)
                    )
                )
            )
        )
    }
}