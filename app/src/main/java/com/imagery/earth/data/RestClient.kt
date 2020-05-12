package com.imagery.earth.data

import com.imagery.earth.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RestClient {
    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(provideGsonConverterFactory())
            .client(provideOkHttpClient())
            .baseUrl(provideBaseUrl())
            .build()
    }

    private fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    private fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    private fun provideOkHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .apply {
                level =
                    if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
            }

        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
}