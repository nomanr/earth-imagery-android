package com.imagery.earth.data

import retrofit2.http.GET
import retrofit2.http.Query

interface ImageRemoteDataSource {

    @GET("natural/images")
    suspend fun getNaturalImages(@Query("api_key") apiKey: String): List<Image>

}