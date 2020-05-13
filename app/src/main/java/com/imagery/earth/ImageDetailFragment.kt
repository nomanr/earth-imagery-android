package com.imagery.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.imagery.earth.databinding.FragmentImageDetailBinding
import com.imagery.earth.utilities.InjectorUtils
import com.imagery.earth.viewmodels.ImageDetailViewModel

class ImageDetailFragment : Fragment() {
    private val viewModel: ImageDetailViewModel by viewModels {
        InjectorUtils.provideImageDetailViewModelFactory(
            this,
            ImageDetailFragmentArgs.fromBundle(requireArguments()).image
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageDetailBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel

        viewModel.snackbar.observe(viewLifecycleOwner, Observer {
            Snackbar.make(binding.root, it, Snackbar.LENGTH_SHORT).show()
        })

        return binding.root
    }
}