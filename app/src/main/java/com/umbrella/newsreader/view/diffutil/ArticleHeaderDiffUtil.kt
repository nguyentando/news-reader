package com.umbrella.newsreader.view.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.umbrella.newsreader.model.ArticleHeaderItemUI

class ArticleHeaderDiffUtil : DiffUtil.ItemCallback<ArticleHeaderItemUI>() {
    override fun areItemsTheSame(oldItem: ArticleHeaderItemUI, newItem: ArticleHeaderItemUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleHeaderItemUI, newItem: ArticleHeaderItemUI): Boolean {
        return true
    }
}
