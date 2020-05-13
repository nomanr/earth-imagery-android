package com.imagery.earth.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.imagery.earth.NewestImageListFragment
import com.imagery.earth.SavedImageListFragment

const val NEWEST_IMAGE_LIST_INDEX = 0
const val SAVED_IMAGE_LIST_INDEX = 1

class ImagePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragmentsMap: Map<Int, () -> Fragment> = mapOf(
        NEWEST_IMAGE_LIST_INDEX to { NewestImageListFragment() },
        SAVED_IMAGE_LIST_INDEX to { SavedImageListFragment() }
    )

    override fun getItemCount() = fragmentsMap.size

    override fun createFragment(position: Int): Fragment {
        return fragmentsMap[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}