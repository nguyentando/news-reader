package com.umbrella.newsreader.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.umbrella.newsreader.databinding.ArticleDescriptionBinding
import com.umbrella.newsreader.databinding.ArticleTitleBinding
import com.umbrella.newsreader.model.ArticleItemUI

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
}