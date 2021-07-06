package com.umbrella.newsreader.view.articledetail.smart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ListBinding
import com.umbrella.newsreader.util.launchAndCollectIn
import com.umbrella.newsreader.util.spacePrettySmall
import com.umbrella.newsreader.util.viewBinding
import com.umbrella.newsreader.view.decoration.ArticleDetailSmartDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailSmartFragment : Fragment(R.layout.list) {
    private val vm by viewModels<ArticleDetailSmartViewModel>()
    private val binding by viewBinding(ListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val articleDetailSmartAdapter = ArticleDetailSmartAdapter()
        binding.rcv.apply {
            adapter = articleDetailSmartAdapter
            addItemDecoration(ArticleDetailSmartDecorator(spacePrettySmall))
        }
        vm.data.launchAndCollectIn(viewLifecycleOwner) {
            articleDetailSmartAdapter.submitList(it)
        }
    }
}