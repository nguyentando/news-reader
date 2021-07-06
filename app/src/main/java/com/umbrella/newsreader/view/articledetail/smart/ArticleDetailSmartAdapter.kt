package com.umbrella.newsreader.view.articledetail.smart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.*
import com.umbrella.newsreader.model.ArticleItemUI
import com.umbrella.newsreader.view.diffutil.ArticleItemUIDiffUtil
import com.umbrella.newsreader.view.viewholder.ArticleDetailVH

class ArticleDetailSmartAdapter(private val requestManager: RequestManager) : ListAdapter<ArticleItemUI, ArticleDetailVH>(ArticleItemUIDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleDetailVH {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.article_description -> {
                ArticleDetailVH.ArticleDescriptionVH(ArticleDescriptionBinding.inflate(inflater, parent, false))
            }
            R.layout.article_title -> {
                ArticleDetailVH.ArticleTitleVH(ArticleTitleBinding.inflate(inflater, parent, false))
            }
            R.layout.article_text -> {
                ArticleDetailVH.ArticleTextVH(ArticleTextBinding.inflate(inflater, parent, false))
            }
            R.layout.article_image -> {
                ArticleDetailVH.ArticleImageVH(requestManager, ArticleImageBinding.inflate(inflater, parent, false))
            }
            R.layout.article_caption -> {
                ArticleDetailVH.ArticleCaptionVH(ArticleCaptionBinding.inflate(inflater, parent, false))
            }
            else -> throw IllegalArgumentException("Invalid viewType")
        }
    }

    override fun onBindViewHolder(holder: ArticleDetailVH, position: Int) {
        val item = getItem(position)
        when (holder) {
            is ArticleDetailVH.ArticleDescriptionVH -> holder.bind(item as ArticleItemUI.Description)
            is ArticleDetailVH.ArticleTitleVH -> holder.bind(item as ArticleItemUI.Title)
            is ArticleDetailVH.ArticleTextVH -> holder.bind(item as ArticleItemUI.Text)
            is ArticleDetailVH.ArticleImageVH -> holder.bind(item as ArticleItemUI.Image)
            is ArticleDetailVH.ArticleCaptionVH -> holder.bind(item as ArticleItemUI.Caption)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is ArticleItemUI.Description -> R.layout.article_description
            is ArticleItemUI.Title -> R.layout.article_title
            is ArticleItemUI.Image -> R.layout.article_image
            is ArticleItemUI.Text -> R.layout.article_text
            is ArticleItemUI.Caption -> R.layout.article_caption
        }
    }
}