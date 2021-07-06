package com.umbrella.newsreader.view.articlelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.umbrella.data.model.article.Article
import com.umbrella.newsreader.databinding.ItemArticleBinding
import com.umbrella.newsreader.view.diffutil.ArticleDiffUtil
import com.umbrella.newsreader.view.viewholder.ArticleViewHolder

class ArticleAdapter(private val requestManager: RequestManager) : ListAdapter<Article, ArticleViewHolder>(ArticleDiffUtil()) {

    var callback: Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            requestManager,
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener { view ->
                val pos = bindingAdapterPosition
                if (pos >= 0) {
                    getItem(pos)?.let {
                        callback?.onClick(view, pos, it)
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    interface Callback {
        fun onClick(view: View, pos: Int, item: Article)
    }
}