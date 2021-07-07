package com.umbrella.data.model.article


import com.umbrella.data.util.MapDto
import com.umbrella.data.util.UnknownException
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDetailDto(
    @SerialName("content")
    val content: ArticleDto? = null,
    @SerialName("related")
    val related: ArticleFooterDto? = null
) : MapDto<ArticleDetail> {

    override fun map(): ArticleDetail {
        val header = content?.map() ?: throw UnknownException
        val body = content.body?.mapNotNull {
            it?.map()
        } ?: emptyList()
        val footer = related?.map()
        return ArticleDetail(header, body, footer)
    }
}

data class ArticleDetail(val header: ArticleHeader, val body: List<ArticleBody>, val footer: ArticleFooter?)