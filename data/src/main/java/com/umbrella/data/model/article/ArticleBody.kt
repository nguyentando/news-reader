package com.umbrella.data.model.article

import com.umbrella.data.util.MapDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


sealed class ArticleBody {
    data class Text(val text: String) : ArticleBody()
    data class Image(val url: String, val width: Int, val height: Int) : ArticleBody()
}

@Serializable
data class ArticleBodyDto(
    @SerialName("content")
    val content: String? = null,
    @SerialName("height")
    val height: Int? = null,
    @SerialName("type")
    val type: String? = null,
    @SerialName("width")
    val width: Int? = null
) : MapDto<ArticleBody?> {
    override fun map(): ArticleBody? {
        return when (type) {
            "image" -> {
                val width = width ?: return null
                if (width <= 0) return null
                val height = height ?: return null
                if (height <= 0) return null
                ArticleBody.Image(
                    url = content.orEmpty(),
                    width = width,
                    height = height
                )
            }
            "text" -> {
                ArticleBody.Text(
                    text = content.orEmpty()
                )
            }
            else -> return null
        }
    }
}