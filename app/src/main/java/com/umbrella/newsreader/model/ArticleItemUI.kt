package com.umbrella.newsreader.model

sealed class ArticleItemUI {
    data class Title(val text: String) : ArticleItemUI()
    data class Description(val text: String) : ArticleItemUI()
    data class Text(val text: String) : ArticleItemUI()
    data class Image(val url: String, val width: Int, val height: Int) : ArticleItemUI()
}