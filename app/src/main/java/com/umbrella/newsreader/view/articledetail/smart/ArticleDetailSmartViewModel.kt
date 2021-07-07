package com.umbrella.newsreader.view.articledetail.smart

import android.os.Build
import android.text.Html
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbrella.data.model.article.ArticleBody
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.data.util.data
import com.umbrella.domain.di.IoDispatcher
import com.umbrella.domain.usecase.article.GetArticleDetailParam
import com.umbrella.domain.usecase.article.GetArticleDetailUseCase
import com.umbrella.newsreader.model.ArticleItemUI
import com.umbrella.newsreader.util.HtmlTagHandler
import com.umbrella.newsreader.util.SavedStateHandleManager
import com.umbrella.newsreader.view.delegate.ArticleListDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ArticleDetailSmartViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    savedStateHandleManager: SavedStateHandleManager,
    private val getArticleDetailUseCase: GetArticleDetailUseCase,
    private val htmlTagHandler: HtmlTagHandler,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val articleListDelegate: ArticleListDelegate
) : ViewModel(), ArticleListDelegate by articleListDelegate {
    private val articleHeader = savedStateHandleManager.getNavArgs<ArticleHeader>(savedStateHandle)
    private val headerUIList = articleHeader.let {
        listOf(
            ArticleItemUI.Title(it.title),
            ArticleItemUI.Description(it.description)
        )
    }

    // show header from the savedStateHandle first
    private val _articleItemUIList = MutableStateFlow(headerUIList)
    val articleItemUIList: StateFlow<List<ArticleItemUI>> = _articleItemUIList

    init {
        // then call the API to get the body
        viewModelScope.launch {
            getArticleDetailUseCase(GetArticleDetailParam(articleHeader.id)).data?.let {
                val data = headerUIList.toMutableList()
                // parse in bgThreat
                withContext(ioDispatcher) {
                    it.body.map {
                        when (it) {
                            is ArticleBody.Image -> ArticleItemUI.Image(it.url, it.width, it.height)
                            is ArticleBody.Text -> {

                                val body = if (Build.VERSION.SDK_INT >= 24) {
                                    Html.fromHtml(it.text, Html.FROM_HTML_MODE_LEGACY, null, htmlTagHandler)
                                } else {
                                    Html.fromHtml(it.text, null, htmlTagHandler)
                                }
                                ArticleItemUI.Text(body)
                            }
                            is ArticleBody.Caption -> ArticleItemUI.Caption(it.text)
                            is ArticleBody.H5 -> ArticleItemUI.H5(it.text)
                            is ArticleBody.Quote -> ArticleItemUI.Quote(it.text)
                        }
                    }
                }.let {
                    data.addAll(it)
                }
                it.footer?.let {
                    data.add(ArticleItemUI.Divider)
                    data.add(ArticleItemUI.FooterTitle(it.title))
                }
                _articleItemUIList.value = data
                parseArticleHeaderList(it.footer?.content ?: emptyList())
            }
            // TODO: 06/07/2021 handle error view }
        }
    }
}