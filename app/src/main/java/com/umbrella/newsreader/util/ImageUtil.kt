package com.umbrella.newsreader.util

import android.widget.ImageView
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.umbrella.newsreader.R
import com.umbrella.newsreader.model.PreloadImageModel

fun ImageView.loadImage(requestManager: RequestManager, preloadImageModel: PreloadImageModel) {
    getRequestBuilder(requestManager, preloadImageModel.url, preloadImageModel.width, preloadImageModel.height)
        .into(this)
}

fun ImageView.loadImage(requestManager: RequestManager, url: String?, width: Int? = null, height: Int? = null) {
    getRequestBuilder(requestManager, url, width, height)
        .into(this)
}

fun getRequestBuilder(requestManager: RequestManager, url: String?, width: Int? = null, height: Int? = null): RequestBuilder<*> {
    val requestOptions: RequestOptions = RequestOptions.placeholderOf(R.drawable.image_placeholder)
        .diskCacheStrategy(DiskCacheStrategy.ALL)

    return requestManager
        .load(url)
        .apply(requestOptions)
        .let {
            if (width != null && height != null) {
                it.override(width, height)
            } else {
                it
            }
        }
}