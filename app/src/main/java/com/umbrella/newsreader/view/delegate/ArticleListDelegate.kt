package com.umbrella.newsreader.view.delegate

import androidx.core.text.PrecomputedTextCompat
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.newsreader.model.ArticleHeaderItemUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Named

interface ArticleListDelegate {
    val articleHeaderItemUIList: StateFlow<List<ArticleHeaderItemUI>>
    suspend fun parseArticleHeaderList(data: List<ArticleHeader>)
}

class ArticleListDelegateImpl(
    @Named("itemArticlePrimaryTextPrecomputedParam") private val precomputedPrimaryText: PrecomputedTextCompat.Params,
    @Named("itemArticleSecondaryTextPrecomputedParam") private val precomputedSecondaryText: PrecomputedTextCompat.Params,
    private val ioDispatcher: CoroutineDispatcher,
) : ArticleListDelegate {
    private val _data = MutableStateFlow<List<ArticleHeaderItemUI>>(emptyList())
    override val articleHeaderItemUIList: StateFlow<List<ArticleHeaderItemUI>> = _data

    override suspend fun parseArticleHeaderList(data: List<ArticleHeader>) {
        _data.value = withContext(ioDispatcher) {
            data.map {
                val precomputedTitle = PrecomputedTextCompat.create(it.title, precomputedPrimaryText)
                val precomputedPublisher = PrecomputedTextCompat.create(it.publisher.publisherName, precomputedSecondaryText)
                ArticleHeaderItemUI(precomputedTitle, precomputedPublisher, it)
            }
        }
    }
}