package com.umbrella.newsreader.view.articlelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umbrella.data.model.article.Article
import com.umbrella.data.util.onError
import com.umbrella.data.util.onSuccess
import com.umbrella.domain.usecase.article.GetArticleListParam
import com.umbrella.domain.usecase.article.GetArticleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    private val getArticleListUseCase: GetArticleListUseCase
) : ViewModel() {
    private val _data = MutableStateFlow<List<Article>>(emptyList())
    val data: StateFlow<List<Article>> = _data

    private val _showError = MutableStateFlow<String?>(null)
    val showError: StateFlow<String?> = _showError

    init {
        viewModelScope.launch {
            getArticleListUseCase(GetArticleListParam())
                .onSuccess { _data.value = it }
                .onError { _showError.value = it.toString() }
        }
    }
}