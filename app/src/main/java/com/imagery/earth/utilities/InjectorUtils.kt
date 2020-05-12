package com.imagery.earth.utilities

import androidx.fragment.app.Fragment
import com.imagery.earth.data.ImageRemoteDataSource
import com.imagery.earth.data.ImageRepository
import com.imagery.earth.data.RestClient
import com.imagery.earth.viewmodels.ImageListViewModelFactory

object InjectorUtils {
    private fun getImageRepository(): ImageRepository {
        return ImageRepository(RestClient.retrofit().create(ImageRemoteDataSource::class.java))
    }

    fun provideImageRepository(fragment: Fragment): ImageListViewModelFactory {
        val imageRepository: ImageRepository = getImageRepository()
        return ImageListViewModelFactory(imageRepository, fragment)
    }
}