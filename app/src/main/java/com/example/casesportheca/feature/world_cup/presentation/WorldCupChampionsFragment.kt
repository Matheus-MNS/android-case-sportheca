package com.example.casesportheca.feature.world_cup.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.casesportheca.R
import com.example.casesportheca.databinding.WorldCupChampionsFragmentBinding

class WorldCupChampionsFragment : Fragment() {

    private val binding by lazy { WorldCupChampionsFragmentBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

}