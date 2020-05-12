package com.imagery.earth.data

import com.imagery.earth.BuildConfig

class ImageRepository(private val remoteDataSource: ImageRemoteDataSource) {
    public suspend fun getImages() {
        remoteDataSource.getNaturalImages(BuildConfig.API_KEY)
    }
}