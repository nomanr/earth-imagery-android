package com.imagery.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.imagery.earth.data.Image
import com.imagery.earth.databinding.FragmentImageListBinding
import com.imagery.earth.viewmodels.ImageListViewModel

class ImageListFragment : Fragment() {
    private val viewModel: ImageListViewModel by viewModels()
    private val adapter : ImageAdapter = ImageAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentImageListBinding.inflate(inflater, container, false)

        binding.rvImages.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImages(adapter)
    }


    private fun loadImages(adapter: ImageAdapter) {
        context?.applicationContext?.assets?.open("data.json").use { inputStream ->
            JsonReader(inputStream?.reader()).use { jsonReader ->
                val imageType = object : TypeToken<List<Image>>() {}.type
                val images: List<Image> = Gson().fromJson(jsonReader, imageType)
                adapter.submitList(images)
            }
        }
    }
}