package com.imagery.earth.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imagery.earth.data.Image
import com.imagery.earth.data.ImageRepository
import kotlinx.coroutines.launch

class ImageDetailViewModel(
    private val imageRepository: ImageRepository,
    val image: Image
) : ViewModel() {

    private val _snackbar = MutableLiveData<String>()
    val snackbar: LiveData<String> = _snackbar

    fun saveImage() = viewModelScope.launch {
        val id = imageRepository.insertImage(image)
        if (id > -1)
            _snackbar.value = "Successfully saved!"


    }
}