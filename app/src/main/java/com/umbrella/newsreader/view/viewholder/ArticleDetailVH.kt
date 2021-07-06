package com.umbrella.newsreader.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.*
import com.umbrella.newsreader.model.ArticleItemUI
import com.umbrella.newsreader.util.getDimen
import com.umbrella.newsreader.util.loadImage
import com.umbrella.newsreader.util.screenWidth

sealed class ArticleDetailVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class ArticleDescriptionVH(private val binding: ArticleDescriptionBinding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.Description) {
            binding.root.text = item.text
        }
    }

    class ArticleTitleVH(private val binding: ArticleTitleBinding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.Title) {
            binding.root.text = item.text
        }
    }

    class ArticleTextVH(private val binding: ArticleTextBinding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.Text) {
            binding.root.text = item.text
        }
    }

    class ArticleImageVH(private val requestManager: RequestManager, private val binding: ArticleImageBinding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.Image) {
            val ratio = item.height / item.width.toFloat()
            binding.root.aspectRatio = ratio
            // calculate the width, height ahead
            // there's a bug if we wait until view has size
            val width = binding.root.context.run {
                screenWidth() - getDimen(R.dimen.space_hoz_article_detail).toInt() * 2
            }
            val height = width * ratio
            binding.root.loadImage(requestManager, item.url, width, height.toInt())
        }
    }

    class ArticleCaptionVH(private val binding: ArticleCaptionBinding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.Caption) {
            binding.root.text = item.text
        }
    }

    class ArticleH5VH(private val binding: ArticleH5Binding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.H5) {
            binding.root.text = item.text
        }
    }
}