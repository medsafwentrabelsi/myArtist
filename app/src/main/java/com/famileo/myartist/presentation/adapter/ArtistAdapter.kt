package com.famileo.myartist.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.famileo.myartist.databinding.AdapterArtistItemBinding
import com.famileo.myartist.presentation.models.UiArtist

/**
 * Artist adapter.
 */
class ArtistAdapter : ListAdapter<UiArtist, ArtistViewHolder>(DIFF_UTIL) {

    /** Delete item click listener. */
    var onItemClickListener: ((UiArtist) -> Unit)? = null

    override fun getItemCount() = currentList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        return ArtistViewHolder(
            AdapterArtistItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { onItemClickListener?.invoke(getItem(adapterPosition)) }

        }
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<UiArtist>() {
            override fun areItemsTheSame(oldItem: UiArtist, newItem: UiArtist): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UiArtist, newItem: UiArtist): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

/**
 * Artist view holder.
 */
class ArtistViewHolder(
    private val binding: AdapterArtistItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(holder: UiArtist) {
        binding.data = holder
    }
}