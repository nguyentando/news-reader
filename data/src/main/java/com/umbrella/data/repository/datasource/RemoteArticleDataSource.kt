package com.umbrella.data.repository.datasource

import android.content.Context
import com.umbrella.data.model.RestResponse
import com.umbrella.data.model.article.ArticleDetail
import com.umbrella.data.model.article.ArticleDetailDto
import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.data.model.article.ArticleListDto
import com.umbrella.data.util.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

interface RemoteArticleDataSource {
    fun getArticleList(): Result<List<ArticleHeader>>
    fun getArticleDetail(id: String): Result<ArticleDetail>
}

private fun Context.getStringJson(fileName: String): String {
    val inputStream = assets.open(fileName)
    val size = inputStream.available()
    val buffer = ByteArray(size)
    inputStream.read(buffer)
    inputStream.close()
    return String(buffer)
}

internal class FakeRemoteArticleDataSourceImpl(private val context: Context, private val json: Json, private val errorUtil: ErrorUtil) :
    RemoteArticleDataSource {
    override fun getArticleList(): Result<List<ArticleHeader>> {
        return CallFake.buildSuccess(json.decodeFromString<RestResponse<ArticleListDto>>(context.getStringJson("article_list.json")))
            .toResult(errorUtil).map { data ->
            val newList = mutableListOf<ArticleHeader>()
            (1..10).map {
                newList.addAll(data)
            }
            newList
        }
    }

    override fun getArticleDetail(id: String): Result<ArticleDetail> {
        return CallFake.buildSuccess(json.decodeFromString<RestResponse<ArticleDetailDto>>(context.getStringJson("article_detail.json")))
            .toResult(errorUtil)
    }
}