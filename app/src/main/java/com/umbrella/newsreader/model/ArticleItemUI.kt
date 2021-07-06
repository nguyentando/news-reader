package com.umbrella.newsreader.model

sealed class ArticleItemUI {
    data class Title(val text: String) : ArticleItemUI()
    data class Description(val text: String) : ArticleItemUI()
}