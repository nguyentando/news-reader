package com.umbrella.newsreader.view.articlelist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ListWithToolbarBinding
import com.umbrella.newsreader.util.launchAndCollectIn
import com.umbrella.newsreader.util.spacePrettySmall
import com.umbrella.newsreader.util.viewBinding
import com.umbrella.newsreader.view.decoration.ArtistListDecoration
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
        val articleAdapter = ArticleAdapter(Glide.with(this))
        binding.rcv.apply {
            adapter = articleAdapter
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            addItemDecoration(ArtistListDecoration(spacePrettySmall))
        }
        vm.data.launchAndCollectIn(viewLifecycleOwner) {
            articleAdapter.submitList(it)
        }
    }
}