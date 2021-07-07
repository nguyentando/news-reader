package com.umbrella.newsreader.view.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.umbrella.newsreader.model.ArticleItemUI

class ArticleItemUIDiffUtil : DiffUtil.ItemCallback<ArticleItemUI>() {
    override fun areItemsTheSame(oldItem: ArticleItemUI, newItem: ArticleItemUI): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ArticleItemUI, newItem: ArticleItemUI): Boolean {
        return true
    }
}