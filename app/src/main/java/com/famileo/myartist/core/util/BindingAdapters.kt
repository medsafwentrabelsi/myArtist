package com.famileo.myartist.core.util

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

/**
 * Changes the provided view visibility.
 */
@BindingAdapter("isVisible")
fun setVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}