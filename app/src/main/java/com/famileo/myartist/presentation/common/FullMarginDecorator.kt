package com.famileo.myartist.presentation.common

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * Layout decoration, on all item view sides.
 */
open class FullMarginDecorator(
    /** Margin resource identifier. */
    private val marginRes: Int
) : ItemDecoration() {
    /** Resolved margin. */
    private var margin = 0

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        (parent.layoutManager as? LinearLayoutManager)?.let { linearLayoutManager ->
            if (margin == 0) {
                margin = parent.resources.getDimensionPixelSize(marginRes)
            }

            when (linearLayoutManager.orientation) {
                RecyclerView.VERTICAL -> outRect.set(margin, margin / 2, margin, margin / 2)
                RecyclerView.HORIZONTAL -> outRect.set(margin / 2, margin, margin / 2, margin)
            }
        }
    }

}