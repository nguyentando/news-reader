package com.umbrella.newsreader.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.newsreader.databinding.ItemArticleBinding
import com.umbrella.newsreader.util.loadImage

class ArticleHeaderVH(private val requestManager: RequestManager, private val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: ArticleHeader) {
        binding.apply {
            imgv.loadImage(requestManager, item.image)
            tvPrimary.text = item.title
            tvSecondary.text = item.publisher.publisherName
        }
    }
}