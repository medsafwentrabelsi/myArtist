package com.famileo.myartist.presentation.extension

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * @return a vertical linear layout manager.
 */
fun RecyclerView.setVerticalLinearLayoutManager() {
    layoutManager = object : LinearLayoutManager(context, RecyclerView.VERTICAL, false) {
        override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
            return RecyclerView.LayoutParams(
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT
            )
        }
    }
}


