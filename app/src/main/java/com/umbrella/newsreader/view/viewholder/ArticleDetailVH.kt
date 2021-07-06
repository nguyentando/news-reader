package com.umbrella.newsreader.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.umbrella.newsreader.databinding.ArticleDescriptionBinding
import com.umbrella.newsreader.databinding.ArticleImageBinding
import com.umbrella.newsreader.databinding.ArticleTextBinding
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

    class ArticleTextVH(private val binding: ArticleTextBinding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.Text) {
            binding.root.text = item.text
        }
    }

    class ArticleImageVH(private val binding: ArticleImageBinding) : ArticleDetailVH(binding.root) {
        fun bind(item: ArticleItemUI.Image) {
            // TODO: 06/07/2021
        }
    }
}