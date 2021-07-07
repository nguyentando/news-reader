package com.umbrella.newsreader.view.articledetail.smart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import com.bumptech.glide.Glide
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ListBinding
import com.umbrella.newsreader.model.ImageViewerModel
import com.umbrella.newsreader.util.launchAndCollectIn
import com.umbrella.newsreader.util.safeNavigate
import com.umbrella.newsreader.util.spaceLarge
import com.umbrella.newsreader.util.viewBinding
import com.umbrella.newsreader.view.articledetail.ArticleDetailContainerFragmentDirections
import com.umbrella.newsreader.view.articlelist.ArticleAdapter
import com.umbrella.newsreader.view.decoration.ArticleDetailSmartDecorator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticleDetailSmartFragment : Fragment(R.layout.list) {
    private val vm by viewModels<ArticleDetailSmartViewModel>()
    private val binding by viewBinding(ListBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // render the header and the body of article
        val articleDetailSmartAdapter = ArticleDetailSmartAdapter(Glide.with(this)).apply {
            callback = object : ArticleDetailSmartAdapter.Callback {
                override fun onClickImage(view: View, pos: Int, image: String) {
                    view.findNavController().safeNavigate(
                        ArticleDetailContainerFragmentDirections.actionArticleDetailFragmentToImageViewerFragment(
                            ImageViewerModel(image)
                        )
                    )
                }
            }
        }
        // render the footer (like recommended articles)
        val articleAdapter = ArticleAdapter(Glide.with(this))
        val concatAdapter = ConcatAdapter(
            ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(), articleDetailSmartAdapter, articleAdapter
        )
        binding.paddingBottom = spaceLarge
        binding.rcv.apply {
            adapter = concatAdapter
            addItemDecoration(ArticleDetailSmartDecorator(requireContext()))
        }
        vm.articleItemUIList.launchAndCollectIn(viewLifecycleOwner) {
            articleDetailSmartAdapter.submitList(it)
        }
        vm.articleHeaderItemUIList.launchAndCollectIn(viewLifecycleOwner) {
            articleAdapter.submitList(it)
        }
    }
}