package com.umbrella.newsreader.model

import com.umbrella.data.model.article.ArticleHeader

data class ArticleHeaderItemUI(
    val precomputedTitle: CharSequence,
    val precomputedPublisherName: CharSequence,
    val articleHeader: ArticleHeader
)