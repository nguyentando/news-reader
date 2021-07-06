package com.umbrella.newsreader.util

import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.umbrella.newsreader.R

fun ImageView.loadImage(requestManager: RequestManager, url: String?) {
    val requestOptions: RequestOptions = RequestOptions.placeholderOf(R.drawable.image_placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)

    requestManager
        .load(url)
        .apply(requestOptions)
        .into(this)
}