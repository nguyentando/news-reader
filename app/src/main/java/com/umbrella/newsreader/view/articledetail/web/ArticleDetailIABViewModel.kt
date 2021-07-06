package com.umbrella.newsreader.view.articledetail.web

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.umbrella.data.model.article.Article
import com.umbrella.newsreader.util.SavedStateHandleManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ArticleDetailIABViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    savedStateHandleManager: SavedStateHandleManager
) : ViewModel() {
    private val _loadWeb = MutableStateFlow(savedStateHandleManager.getNavArgs<Article>(savedStateHandle).url)
    val loadWeb: StateFlow<String> = _loadWeb
    private val _showLoading = MutableStateFlow(true)
    val showLoading: StateFlow<Boolean> = _showLoading

    fun onUpdateProgress(progress: Int) {
        _showLoading.value = progress < 100
    }

    fun onPageFinished() {
        _showLoading.value = false
    }

    fun onReceivedError() {
        _showLoading.value = false
    }
}