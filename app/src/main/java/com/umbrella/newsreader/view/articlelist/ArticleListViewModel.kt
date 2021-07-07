package com.umbrella.newsreader.view.articlelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbrella.data.util.Result
import com.umbrella.domain.usecase.article.GetArticleListParam
import com.umbrella.domain.usecase.article.GetArticleListUseCase
import com.umbrella.newsreader.view.delegate.ArticleListDelegate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase,
    private val articleListDelegate: ArticleListDelegate
) : ViewModel(), ArticleListDelegate by articleListDelegate {

    private val _showError = MutableStateFlow<String?>(null)
    val showError: StateFlow<String?> = _showError

    init {

        viewModelScope.launch {
            when (val result = getArticleListUseCase(GetArticleListParam())) {
                is Result.Error -> {
                    // TODO: 07/07/2021 handle show error view
                }
                is Result.Success -> {
                    parseArticleHeaderList(result.data)
                }
            }
        }
    }
}