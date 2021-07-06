package com.umbrella.newsreader.view.articledetail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.umbrella.newsreader.util.newInstanceFragment
import com.umbrella.newsreader.view.articledetail.smart.ArticleDetailSmartFragment
import com.umbrella.newsreader.view.articledetail.web.ArticleDetailIABFragment

private const val SUPPORT_PAGE_NUMB = 2

class ArticleDetailContainerAdapter(frag: Fragment) : FragmentStateAdapter(frag) {
    companion object {
        const val WEB = "Web"
        const val SMART = "Smart"
    }

    private var positions: List<String> = listOf(
        WEB, SMART
    )

    override fun getItemCount() = positions.size.coerceAtMost(SUPPORT_PAGE_NUMB)

    override fun createFragment(position: Int): Fragment {
        return when (positions[position]) {
            WEB -> {
                newInstanceFragment<ArticleDetailIABFragment>(null)
            }
            SMART -> {
                newInstanceFragment<ArticleDetailSmartFragment>(null)
            }
            else -> {
                throw IllegalStateException()
            }
        }
    }

    fun getPageName(position: Int) = positions[position]
}