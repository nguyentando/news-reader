package com.umbrella.newsreader.view.articledetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleDetailContainerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val args = ArticleDetailContainerFragmentArgs.fromSavedStateHandle(savedStateHandle).article
}