package com.imagery.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.imagery.earth.adapters.ImageAdapter
import com.imagery.earth.databinding.FragmentImageListBinding
import com.imagery.earth.utilities.InjectorUtils
import com.imagery.earth.viewmodels.ImageListViewModel

class SavedImageListFragment : Fragment() {
    private val viewModel: ImageListViewModel by viewModels {
        InjectorUtils.provideImageRepository(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageListBinding.inflate(inflater, container, false)
        val adapter = ImageAdapter()
        with(binding) {
            viewmodel = viewModel
            rvImages.adapter = adapter
            lifecycleOwner = this@SavedImageListFragment
        }
        observeImages(adapter)
        return binding.root
    }


    private fun observeImages(adapter: ImageAdapter) {
        viewModel.imageList.observe(viewLifecycleOwner, Observer { images ->
            adapter.submitList(images)
        })
    }

}