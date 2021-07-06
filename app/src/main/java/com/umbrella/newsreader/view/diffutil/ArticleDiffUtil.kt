package com.umbrella.newsreader.view.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.umbrella.data.model.article.ArticleHeader

class ArticleDiffUtil : DiffUtil.ItemCallback<ArticleHeader>() {
    override fun areItemsTheSame(oldItem: ArticleHeader, newItem: ArticleHeader): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleHeader, newItem: ArticleHeader): Boolean {
        return true
    }
}
