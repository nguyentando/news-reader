package com.umbrella.newsreader.view.articledetail.smart

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.newsreader.model.ArticleItemUI
import com.umbrella.newsreader.util.SavedStateHandleManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ArticleDetailSmartViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    savedStateHandleManager: SavedStateHandleManager
) : ViewModel() {
    private val articleHeader = savedStateHandleManager.getNavArgs<ArticleHeader>(savedStateHandle)
    private val headerUIList = articleHeader.let {
        listOf(
            ArticleItemUI.Title(it.title),
            ArticleItemUI.Description(it.description)
        )
    }
    private val _data = MutableStateFlow(headerUIList)
    val data: StateFlow<List<ArticleItemUI>> = _data
}