package com.imagery.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.imagery.earth.adapters.NEWEST_IMAGE_LIST_INDEX
import com.imagery.earth.adapters.ImagePagerAdapter
import com.imagery.earth.adapters.SAVED_IMAGE_LIST_INDEX
import com.imagery.earth.databinding.FragmentHomeViewPagerBinding


class HomeViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeViewPagerBinding.inflate(inflater, container, false)
        binding.viewPager.adapter = ImagePagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }


    private fun getTabTitle(position: Int): String? {
        return when (position) {
            NEWEST_IMAGE_LIST_INDEX -> getString(R.string.latest_images)
            SAVED_IMAGE_LIST_INDEX -> getString(R.string.saved_images)
            else -> null
        }
    }


}