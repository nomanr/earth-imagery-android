package com.imagery.earth.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.imagery.earth.BuildConfig
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "image_data")
data class Image(
    @PrimaryKey @ColumnInfo(name = "image_id") val identifier: String,
    @ColumnInfo(name = "caption") val caption: String,
    @ColumnInfo(name = "image_url") val image: String,
    @ColumnInfo(name = "image_date") val date: String
) : Parcelable {

    //TODO: improve it later on, maybe write a coil mapper and URL builder.
    fun getImageUrl(): String {
        val formattedDate = date.split(" ")[0].replace("-", "/")
        return "https://api.nasa.gov/EPIC/archive/natural/${formattedDate}/png/${image}.png?api_key=${BuildConfig.API_KEY}"

    }

}