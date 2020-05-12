package com.imagery.earth.data

import com.imagery.earth.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepository(private val remoteDataSource: ImageRemoteDataSource) {
    suspend fun getImages() = withContext(Dispatchers.IO) {
        remoteDataSource.getNaturalImages(BuildConfig.API_KEY)
    }
}