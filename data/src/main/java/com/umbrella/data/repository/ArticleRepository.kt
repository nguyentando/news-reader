package com.umbrella.data.repository

import com.umbrella.data.model.article.Article
import com.umbrella.data.repository.datasource.RemoteArticleDataSource
import com.umbrella.data.util.Result

interface ArticleRepository {
    fun getArticleList(): Result<List<Article>>
}

internal class ArticleRepositoryImpl(private val remoteArticleDataSource: RemoteArticleDataSource) : ArticleRepository {
    override fun getArticleList(): Result<List<Article>> {
        return remoteArticleDataSource.getArticleList()
    }
}