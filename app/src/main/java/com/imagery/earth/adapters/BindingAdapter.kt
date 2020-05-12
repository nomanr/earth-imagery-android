package com.imagery.earth.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.api.load
import com.imagery.earth.R

@BindingAdapter("imageFromUrl")
fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
    if (!imageUrl.isNullOrEmpty()) {
        view.load(imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_background)
        }
    }
}
