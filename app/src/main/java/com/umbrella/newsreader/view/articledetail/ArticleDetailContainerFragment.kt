package com.umbrella.newsreader.view.articledetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ArticleDetailContainerBinding
import com.umbrella.newsreader.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailContainerFragment : Fragment(R.layout.article_detail_container) {
    private val binding by viewBinding(ArticleDetailContainerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val articleDetailContainerAdapter = ArticleDetailContainerAdapter(this)
        binding.vPager.apply {
            isUserInputEnabled = false
            adapter = articleDetailContainerAdapter
        }

        TabLayoutMediator(binding.tab, binding.vPager) { tab, pos ->
            tab.text = articleDetailContainerAdapter.getPageName(pos)
        }.attach()
    }
}