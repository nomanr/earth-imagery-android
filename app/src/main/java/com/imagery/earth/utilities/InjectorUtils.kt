package com.imagery.earth.utilities

import android.content.Context
import androidx.fragment.app.Fragment
import com.imagery.earth.data.*
import com.imagery.earth.viewmodels.ImageDetailViewModelFactory
import com.imagery.earth.viewmodels.ImageListViewModelFactory

/**
 * Refactor this to dagger later on
 */

object InjectorUtils {
    private fun getImageRemoteDataSource() =
        RestClient.retrofit().create(ImageRemoteDataSource::class.java)

    private fun getImageLocalDataSource(context: Context) =
        ImageLocalDataSource(AppDatabase.getInstance(context).imageDao())

    private fun getImageRepository(context: Context): ImageRepository {
        return ImageRepository.getInstance(
            getImageRemoteDataSource(),
            getImageLocalDataSource(context)
        )
    }

    fun provideImageListViewModelFactory(fragment: Fragment): ImageListViewModelFactory {
        val imageRepository: ImageRepository =
            getImageRepository(fragment.requireContext().applicationContext)
        return ImageListViewModelFactory(imageRepository, fragment)
    }

    fun provideImageDetailViewModelFactory(
        fragment: Fragment,
        image: Image
    ): ImageDetailViewModelFactory {
        val imageRepository: ImageRepository =
            getImageRepository(fragment.requireContext().applicationContext)
        return ImageDetailViewModelFactory(imageRepository, image, fragment)
    }
}