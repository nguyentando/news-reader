package com.umbrella.newsreader.binding

import androidx.core.view.updatePadding
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("isLinearList")
fun RecyclerView.bindLinear(isLinear: Boolean?) {
    // default rcv uses LinearLayoutManager
    if (isLinear == null || isLinear == true) {
        layoutManager = LinearLayoutManager(context)
    }
    setHasFixedSize(true)
}

@BindingAdapter("paddingBottom")
fun RecyclerView.bindPaddingBottom(paddingBottom: Int?) {
    paddingBottom?.let {
        clipToPadding = false
        updatePadding(bottom = paddingBottom)
    }
}