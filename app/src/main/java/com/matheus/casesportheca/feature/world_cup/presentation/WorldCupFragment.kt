package com.matheus.casesportheca.feature.world_cup.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.matheus.casesportheca.databinding.WorldCupFragmentBinding
import com.matheus.casesportheca.feature.world_cup.domain.model.Player
import org.koin.androidx.viewmodel.ext.android.viewModel

class WorldCupFragment : Fragment() {

    private val binding by lazy { WorldCupFragmentBinding.inflate(layoutInflater) }
    private val viewModel: WorldCupViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handleObserver()
    }

    private fun handleObserver() {
        viewModel.loading.observe(
            viewLifecycleOwner, Observer(
                ::handleLoading
            )
        )
        viewModel.player.observe(
            viewLifecycleOwner, Observer(
                ::handlePlayerState
            )
        )
        viewModel.error.observe(
            viewLifecycleOwner, Observer(
                ::handleError
            )
        )
    }

    private fun handleLoading(loading: Boolean) {
        binding.loadingProgressBar.isVisible = loading
    }

    private fun handlePlayerState(player: Player) {

    }

    private fun handleError(message: String) {

    }
}