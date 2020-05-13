package com.imagery.earth.viewmodels

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.imagery.earth.NewestImageListFragment
import com.imagery.earth.data.ImageRepository


class ImageListViewModelFactory(
    private val repository: ImageRepository,
    private val owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return if (owner is NewestImageListFragment)
            NewestImageListViewModel(repository) as T
        else
            SavedImageListViewModel(repository) as T
    }
}
