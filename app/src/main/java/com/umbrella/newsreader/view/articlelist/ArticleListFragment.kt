package com.umbrella.newsreader.view.articlelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ListWithToolbarBinding
import com.umbrella.newsreader.util.launchAndCollectIn
import com.umbrella.newsreader.util.safeNavigate
import com.umbrella.newsreader.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment(R.layout.list_with_toolbar) {
    private val binding by viewBinding(ListWithToolbarBinding::bind)
    private val vm by viewModels<ArticleListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.apply {
            showBack = false
            title = getString(R.string.app_name)
        }
        val articleAdapter = ArticleAdapter(Glide.with(this)).apply {
            callback = object : ArticleAdapter.Callback {
                override fun onClick(view: View, pos: Int, item: ArticleHeader) {
                    view.findNavController().safeNavigate(ArticleListFragmentDirections.actionArticleListFragmentToArticleDetailFragment(item))
                }
            }
        }
        binding.list.rcv.apply {
            adapter = articleAdapter
        }
        vm.data.launchAndCollectIn(viewLifecycleOwner) {
            articleAdapter.submitList(it)
        }
    }
}