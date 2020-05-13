package com.imagery.earth.data

import androidx.lifecycle.LiveData

class ImageLocalDataSource(private val imageDao: ImageDao) {

    fun getAllImages(): LiveData<List<Image>> = imageDao.getImages();

    suspend fun insertImage(image: Image) = imageDao.insertImage(image)
}