package com.imagery.earth.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imagery.earth.data.Image
import com.imagery.earth.data.ImageRepository
import kotlinx.coroutines.launch

class NewestImageListViewModel(
    private val imageRepository: ImageRepository
) : ViewModel() {

    init {
        getImages()
    }
    val imageList: MutableLiveData<List<Image>> = MutableLiveData()
    private val _loader = MutableLiveData<Boolean>(true)
    val loader: LiveData<Boolean> = _loader

    private fun getImages() = viewModelScope.launch {
        val response = imageRepository.getImages()
        imageList.value = response
        _loader.value = false
    }

}