package com.umbrella.newsreader.view.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.umbrella.newsreader.R
import com.umbrella.newsreader.util.getDimen
import com.umbrella.newsreader.util.spaceAboveNormal
import com.umbrella.newsreader.util.spaceTiny
import com.umbrella.newsreader.view.viewholder.ArticleDetailVH
import com.umbrella.newsreader.view.viewholder.ArticleHeaderVH

class ArticleDetailSmartDecorator(context: Context) : RecyclerView.ItemDecoration() {
    private val spaceHoz = context.getDimen(R.dimen.space_hoz_article_detail).toInt()
    private val spaceVer = context.spaceAboveNormal
    private val spaceTiny = context.spaceTiny

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        // don't offset horizontal if meet divider or recommended articles
        val childVH = parent.getChildViewHolder(view)
        if (childVH !is ArticleDetailVH.ArticleDivider && childVH !is ArticleHeaderVH) {
            outRect.left = spaceHoz
            outRect.right = spaceHoz
        }
        // don't offset the vertical if meet recommended articles
        if (childVH !is ArticleHeaderVH) {
            outRect.top = spaceVer
        } else if (childVH.bindingAdapterPosition == 0) {
            // if meet the first recommended articles, offset top a little bit
            outRect.top = spaceTiny
        }
    }
}