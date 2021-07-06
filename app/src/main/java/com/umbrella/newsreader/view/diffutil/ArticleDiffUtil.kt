package com.umbrella.newsreader.view.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.umbrella.data.model.article.Article

class ArticleDiffUtil : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return true
    }
}
