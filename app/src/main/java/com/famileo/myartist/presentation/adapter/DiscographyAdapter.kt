package com.famileo.myartist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.famileo.myartist.databinding.AdapterArtistDiscographyItemBinding
import com.famileo.myartist.presentation.models.UiDiscography

/**
 * Artist adapter.
 */
class DiscographyAdapter : ListAdapter<UiDiscography, DiscographyViewHolder>(DIFF_UTIL) {

    override fun getItemCount() = currentList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscographyViewHolder {
        return DiscographyViewHolder(
            AdapterArtistDiscographyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {

        }
    }

    override fun onBindViewHolder(holder: DiscographyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<UiDiscography>() {
            override fun areItemsTheSame(oldItem: UiDiscography, newItem: UiDiscography): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: UiDiscography, newItem: UiDiscography): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}

/**
 * Artist view holder.
 */
class DiscographyViewHolder(
    private val binding: AdapterArtistDiscographyItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(holder: UiDiscography) {
        binding.data = holder
    }
}