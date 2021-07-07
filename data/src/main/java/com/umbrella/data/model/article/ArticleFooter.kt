package com.umbrella.data.model.article

import com.umbrella.data.util.MapDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleFooterDto(
    @SerialName("contents")
    val contents: List<ArticleDto?>? = null,
    @SerialName("title")
    val title: String? = null
) : MapDto<ArticleFooter> {

    override fun map(): ArticleFooter {
        return ArticleFooter(
            title = title.orEmpty(),
            content = contents?.mapNotNull {
                it?.map()
            } ?: emptyList()
        )
    }
}

data class ArticleFooter(val title: String, val content: List<ArticleHeader>)
