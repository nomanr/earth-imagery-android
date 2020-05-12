package com.imagery.earth.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imagery.earth.data.Image
import com.imagery.earth.data.ImageRepository
import kotlinx.coroutines.launch

class ImageDetailViewModel(
    private val imageRepository: ImageRepository,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val imageList = MutableLiveData<List<Image>>()

    fun getImages() = viewModelScope.launch {
        val response = imageRepository.getImages()
        imageList.value = response
    }

}