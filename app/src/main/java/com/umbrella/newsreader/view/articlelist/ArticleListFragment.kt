package com.umbrella.newsreader.view.articlelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ListWithToolbarBinding
import com.umbrella.newsreader.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleListFragment : Fragment(R.layout.list_with_toolbar) {
    private val binding by viewBinding(ListWithToolbarBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.apply {
            showBack = false
            title = getString(R.string.app_name)
        }
    }
}