package com.matheus.casesportheca.feature.world_cup.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheus.casesportheca.feature.world_cup.domain.model.Player
import com.matheus.casesportheca.feature.world_cup.domain.use_case.GetPlayerUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class WorldCupViewModel(private val getPlayerUseCase: GetPlayerUseCase) : ViewModel() {

    val player: MutableLiveData<Player> by lazy {
        MutableLiveData<Player>()
    }

    val loading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    val error: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    init {
        getPlayer()
    }

    private fun getPlayer() {
        viewModelScope.launch {
            getPlayerUseCase()
                .flowOn(Dispatchers.IO)
                .onStart { loading.value = true }
                .onCompletion { loading.value = false }
                .catch { handleError(it) }
                .collect { handleSuccess(it) }
        }
    }

    private fun handleSuccess(player: Player) {
        this.player.value = player
    }

    private fun handleError(throwable: Throwable) {
    }
}