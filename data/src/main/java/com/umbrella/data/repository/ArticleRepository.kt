package com.umbrella.data.repository

import com.umbrella.data.model.article.ArticleDetail
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.data.repository.datasource.RemoteArticleDataSource
import com.umbrella.data.util.Result

interface ArticleRepository {
    fun getArticleList(): Result<List<ArticleHeader>>
    fun getArticleDetail(id: String): Result<ArticleDetail>
}

internal class ArticleRepositoryImpl(private val remoteArticleDataSource: RemoteArticleDataSource) : ArticleRepository {
    override fun getArticleList(): Result<List<ArticleHeader>> {
        return remoteArticleDataSource.getArticleList()
    }

    override fun getArticleDetail(id: String): Result<ArticleDetail> {
        return remoteArticleDataSource.getArticleDetail(id)
    }
}