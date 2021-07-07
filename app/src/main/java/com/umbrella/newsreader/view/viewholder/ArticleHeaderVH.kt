package com.umbrella.newsreader.view.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ItemArticleBinding
import com.umbrella.newsreader.model.ArticleHeaderItemUI
import com.umbrella.newsreader.model.PreloadImageModel
import com.umbrella.newsreader.util.addRipple
import com.umbrella.newsreader.util.getDimen
import com.umbrella.newsreader.util.loadImage

class ArticleHeaderVH(private val requestManager: RequestManager, private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun getPreloadImage(context: Context, item: ArticleHeaderItemUI): PreloadImageModel {
            val width = context.getDimen(R.dimen.article_item_width)
            val aspectRatio = context.getString(R.string.article_image_ratio).let { ratio ->
                val wh = ratio.split(":").toTypedArray()
                wh[0].toFloat() / wh[1].toFloat()
            }
            val height = width * aspectRatio
            return PreloadImageModel(item.articleHeader.image, width.toInt(), height.toInt())
        }
    }

    init {
        binding.root.addRipple()
    }

    fun bind(item: ArticleHeaderItemUI) {
        binding.apply {
            imgv.loadImage(requestManager, getPreloadImage(context = root.context, item = item))
            tvPrimary.text = item.precomputedTitle
            tvSecondary.text = item.precomputedPublisherName
        }
    }
}