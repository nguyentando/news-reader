package com.umbrella.newsreader.view.articlelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ItemArticleBinding
import com.umbrella.newsreader.model.ArticleHeaderItemUI
import com.umbrella.newsreader.view.diffutil.ArticleHeaderDiffUtil
import com.umbrella.newsreader.view.viewholder.ArticleHeaderVH

class ArticleAdapter(private val requestManager: RequestManager) : ListAdapter<ArticleHeaderItemUI, ArticleHeaderVH>(ArticleHeaderDiffUtil()) {

    var callback: Callback? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleHeaderVH {
        return ArticleHeaderVH(
            requestManager,
            ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        ).apply {
            itemView.setOnClickListener { view ->
                val pos = bindingAdapterPosition
                if (pos >= 0) {
                    getItem(pos)?.let {
                        callback?.onClick(view, pos, it.articleHeader)
                    }
                }
            }
        }
    }

    override fun onBindViewHolder(holder: ArticleHeaderVH, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_article
    }

    interface Callback {
        fun onClick(view: View, pos: Int, item: ArticleHeader)
    }
}