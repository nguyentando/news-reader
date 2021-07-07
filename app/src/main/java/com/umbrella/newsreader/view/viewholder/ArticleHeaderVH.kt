package com.umbrella.newsreader.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.umbrella.newsreader.databinding.ItemArticleBinding
import com.umbrella.newsreader.model.ArticleHeaderItemUI
import com.umbrella.newsreader.util.addRipple
import com.umbrella.newsreader.util.loadImage

class ArticleHeaderVH(private val requestManager: RequestManager, private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.root.addRipple()
    }

    fun bind(item: ArticleHeaderItemUI) {
        binding.apply {
            imgv.loadImage(requestManager, item.articleHeader.image)
            tvPrimary.text = item.precomputedTitle
            tvSecondary.text = item.precomputedPublisherName
        }
    }
}