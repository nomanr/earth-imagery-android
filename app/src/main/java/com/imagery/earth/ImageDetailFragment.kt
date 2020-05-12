package com.imagery.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.imagery.earth.databinding.FragmentImageDetailBinding
import com.imagery.earth.viewmodels.ImageDetailViewModel
import com.imagery.earth.viewmodels.ImageDetailViewModelFactory

class ImageDetailFragment : Fragment() {
    private val viewModel: ImageDetailViewModel by viewModels {
        ImageDetailViewModelFactory(
            ImageDetailFragmentArgs.fromBundle(requireArguments()).image, this
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        return binding.root
    }
}