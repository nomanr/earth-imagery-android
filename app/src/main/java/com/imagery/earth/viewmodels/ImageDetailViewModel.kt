package com.imagery.earth.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.imagery.earth.data.Image

class ImageDetailViewModel(
    val image: Image,
    private val savedStateHandle: SavedStateHandle
) : ViewModel()