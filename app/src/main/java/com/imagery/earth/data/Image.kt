package com.imagery.earth.data

import android.os.Parcelable
import com.imagery.earth.BuildConfig
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    val identifier: String,
    val caption: String,
    val image: String,
    val date: String
) : Parcelable {
    fun imageUrl(): String {
        val d = date.split(" ")[0].replace("-","/")
        return "https://api.nasa.gov/EPIC/archive/natural/${d}/png/${image}.png?api_key=${BuildConfig.API_KEY}"
    }
}