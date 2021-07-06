package com.umbrella.newsreader.view.articledetail.smart

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbrella.data.model.article.ArticleBody
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.data.util.onError
import com.umbrella.data.util.onSuccess
import com.umbrella.domain.usecase.article.GetArticleDetailParam
import com.umbrella.domain.usecase.article.GetArticleDetailUseCase
import com.umbrella.newsreader.model.ArticleItemUI
import com.umbrella.newsreader.util.SavedStateHandleManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleDetailSmartViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    savedStateHandleManager: SavedStateHandleManager,
    private val getArticleDetailUseCase: GetArticleDetailUseCase
) : ViewModel() {
    private val articleHeader = savedStateHandleManager.getNavArgs<ArticleHeader>(savedStateHandle)
    private val headerUIList = articleHeader.let {
        listOf(
            ArticleItemUI.Title(it.title),
            ArticleItemUI.Description(it.description)
        )
    }

    // show header from the savedStateHandle first
    private val _data = MutableStateFlow(headerUIList)
    val data: StateFlow<List<ArticleItemUI>> = _data

    // then call the API to get the body
    init {
        viewModelScope.launch {
            getArticleDetailUseCase(GetArticleDetailParam(articleHeader.id))
                .onSuccess {
                    it.let {
                        val data = listOf(headerUIList)
                        it.body.forEach {
                            when (it) {
                                is ArticleBody.Image -> ArticleItemUI.Image(it.url, it.width, it.height)
                                is ArticleBody.Text -> ArticleItemUI.Text(it.text)
                            }
                        }
                        // TODO: 06/07/2021 handle footer
                    }
                }
                .onError {
                    // TODO: 06/07/2021 handle error view }
                }
        }
    }
}