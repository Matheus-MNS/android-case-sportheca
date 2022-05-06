package com.matheus.casesportheca.feature.world_cup.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.matheus.casesportheca.databinding.WorldCupFragmentBinding
import com.matheus.casesportheca.feature.world_cup.domain.model.Player
import com.squareup.picasso.Picasso
import okhttp3.internal.format
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


        with(binding) {
            convertUrl(player.img, userIconImageView)
            userNameTextView.text = player.name
            countryNameTextView.text = player.country
            positionNameTextView.text = player.position
            percentageTextView.text = format("%.3f", player.percentage)
            worldCupWonProgressBar.progress = player.bars.worldCupsWon.max.toInt()
            worldCupWonPlaceTextView.text = player.bars.worldCupsWon.place.toString()
            wordCupWonProportionalTextView.text =
                format("%.1f", player.bars.worldCupsWon.proportional)
            worldCupParticipatedProgressBar.progress = player.bars.worldCupsParticipated.max.toInt()
            worldCupParticipatedPlaceTextView.text =
                player.bars.worldCupsParticipated.place.toString()
            wordCupParticipatedProportionalTextView.text =
                format("%.1f", player.bars.worldCupsParticipated.proportional)
        }
    }

    private fun handleError(message: String) {

    }

    private fun convertUrl(url: String, imageView: ImageView) {

        val transformation = RoundedTransformationBuilder()
            .borderColor(Color.BLACK)
            .borderWidthDp(3f)
            .cornerRadiusDp(30f)
            .oval(true)
            .build()

        Picasso.with(context)
            .load(url)
            .fit()
            .transform(transformation)
            .into(imageView)
    }

}