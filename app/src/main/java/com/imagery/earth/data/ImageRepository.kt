package com.imagery.earth.data

import com.imagery.earth.BuildConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepository(
    private val remoteDataSource: ImageRemoteDataSource,
    private val localDataSource: ImageLocalDataSource
) {
    suspend fun getImages() = withContext(Dispatchers.IO) {
        remoteDataSource.getNaturalImages(BuildConfig.API_KEY)
    }

    fun getSavedImages() = localDataSource.getAllImages()

    suspend fun insertImage(image: Image) = withContext(Dispatchers.IO){
        localDataSource.insertImage(image)
    }

    companion object {

        @Volatile
        private var instance: ImageRepository? = null

        fun getInstance(
            remoteDataSource: ImageRemoteDataSource,
            localDataSource: ImageLocalDataSource
        ) = instance ?: synchronized(this) {
            instance ?: ImageRepository(
                remoteDataSource, localDataSource
            ).also { instance = it }
        }
    }
}