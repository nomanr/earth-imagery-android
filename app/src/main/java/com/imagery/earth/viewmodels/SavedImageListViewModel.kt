package com.imagery.earth.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.imagery.earth.data.Image
import com.imagery.earth.data.ImageRepository

class SavedImageListViewModel(
    private val imageRepository: ImageRepository
) : ViewModel() {
    val savedImageList: LiveData<List<Image>> = imageRepository.getSavedImages()
}