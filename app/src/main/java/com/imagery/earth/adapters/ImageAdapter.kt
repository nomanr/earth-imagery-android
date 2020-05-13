package com.imagery.earth.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.imagery.earth.HomeViewPagerFragmentDirections
import com.imagery.earth.data.Image
import com.imagery.earth.databinding.ListItemImageBinding

class ImageAdapter : ListAdapter<Image, RecyclerView.ViewHolder>(ImageDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ListItemImageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val image = getItem(position)
        (holder as ImageViewHolder).bind(image)
    }

    class ImageViewHolder(private val binding: ListItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                binding.image?.let { image -> navigateToDetails(it, image) }
            }
        }

        private fun navigateToDetails(view: View, image: Image) {
            view.findNavController().navigate(HomeViewPagerFragmentDirections.actionNext(image))
        }

        fun bind(item: Image) {
            binding.apply {
                image = item
                executePendingBindings()
            }
        }
    }

}

private class ImageDiffCallback : DiffUtil.ItemCallback<Image>() {

    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.identifier == newItem.identifier
    }

    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem
    }
}