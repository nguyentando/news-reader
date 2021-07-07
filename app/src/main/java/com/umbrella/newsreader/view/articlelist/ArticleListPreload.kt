package com.umbrella.newsreader.view.articlelist

import android.content.Context
import com.bumptech.glide.ListPreloader
import com.bumptech.glide.RequestBuilder
import com.umbrella.newsreader.model.PreloadImageModel
import com.umbrella.newsreader.util.getRequestBuilder
import com.umbrella.newsreader.view.viewholder.ArticleHeaderVH
import java.util.*

/**
 * Preload ahead the images for article list
 */
class ArticleListPreload(private val context: Context, private val adapter: ArticleAdapter) : ListPreloader.PreloadSizeProvider<PreloadImageModel>,
    ListPreloader.PreloadModelProvider<PreloadImageModel> {

    override fun getPreloadSize(item: PreloadImageModel, adapterPosition: Int, perItemPosition: Int): IntArray? {
        return intArrayOf(item.width, item.height)
    }

    override fun getPreloadItems(position: Int): List<PreloadImageModel> {
        val item = adapter.getItemAt(position) ?: return Collections.emptyList()
        return Collections.singletonList(ArticleHeaderVH.getPreloadImage(context, item))
    }

    override fun getPreloadRequestBuilder(item: PreloadImageModel): RequestBuilder<*> {
        return getRequestBuilder(adapter.requestManager, item.url, item.width, item.height)
    }
}