package com.umbrella.newsreader.model

import android.text.Spanned

sealed class ArticleItemUI {
    data class Title(val text: String) : ArticleItemUI()
    data class Description(val text: String) : ArticleItemUI()
    data class Text(val text: Spanned) : ArticleItemUI()
    data class Image(val url: String, val width: Int, val height: Int) : ArticleItemUI()
    data class Caption(val text: String) : ArticleItemUI()
    data class H5(val text: String) : ArticleItemUI()
    data class FooterTitle(val text: String) : ArticleItemUI()
    data class Quote(val text: String) : ArticleItemUI()
    object Divider : ArticleItemUI()
}