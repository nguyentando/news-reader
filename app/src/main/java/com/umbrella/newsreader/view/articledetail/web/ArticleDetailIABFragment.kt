package com.umbrella.newsreader.view.articledetail.web

import android.os.Bundle
import android.view.View
import android.webkit.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ArticleDetailIabBinding
import com.umbrella.newsreader.util.fadeIn
import com.umbrella.newsreader.util.fadeOut
import com.umbrella.newsreader.util.launchAndCollectIn
import com.umbrella.newsreader.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 * in app browser
 */
@AndroidEntryPoint
class ArticleDetailIABFragment : Fragment(R.layout.article_detail_iab) {
    private val binding by viewBinding(ArticleDetailIabBinding::bind)
    private val vm by viewModels<ArticleDetailIABViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.webView.apply {
            // chromium, enable hardware acceleration
            setLayerType(View.LAYER_TYPE_HARDWARE, null);
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    super.onProgressChanged(view, newProgress)
                    vm.onUpdateProgress(newProgress)
                }
            }
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    vm.onPageFinished()
                }

                override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                    super.onReceivedError(view, request, error)
                    vm.onReceivedError()
                }
            }

        }
        vm.loadWeb.launchAndCollectIn(viewLifecycleOwner) {
            binding.webView.loadUrl(it)
        }
        vm.showLoading.launchAndCollectIn(viewLifecycleOwner) {
            binding.loading.pbLoading.apply {
                if (it) {
                    fadeIn()
                } else {
                    fadeOut()
                }
            }
        }
    }
}