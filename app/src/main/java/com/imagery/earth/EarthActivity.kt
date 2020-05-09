package com.imagery.earth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.imagery.earth.databinding.ActivityEarthBinding

class EarthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityEarthBinding>(this, R.layout.activity_earth)
    }
}
