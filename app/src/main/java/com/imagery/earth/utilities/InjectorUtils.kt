package com.imagery.earth.utilities

import com.imagery.earth.data.ImageRemoteDataSource
import com.imagery.earth.data.ImageRepository
import com.imagery.earth.data.RestClient

object InjectorUtils {
    private fun getImageRepository(): ImageRepository {
        return ImageRepository(RestClient.retrofit().create(ImageRemoteDataSource::class.java))
    }
}