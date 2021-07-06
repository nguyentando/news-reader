package com.umbrella.data.model.article


import android.os.Parcelable
import com.umbrella.data.util.MapDto
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ArticleListDto(
    @SerialName("contents")
    val contents: List<ArticleDto?>? = null
) : MapDto<List<Article>> {
    override fun map(): List<Article> {
        return (contents ?: emptyList<ArticleDto>()).mapNotNull {
            it?.map()
        }
    }
}

@Serializable
class ArticleDto(
    @SerialName("content_id")
    val contentId: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("image")
    val image: String? = null,
    @SerialName("publisher_icon")
    val publisherIcon: String? = null,
    @SerialName("publisher_id")
    val publisherId: String? = null,
    @SerialName("publisher_name")
    val publisherName: String? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("url")
    val url: String? = null
) : MapDto<Article?> {
    override fun map(): Article? {
        return Article(
            id = contentId ?: return null,
            title = title.orEmpty(),
            url = url.orEmpty(),
            description = description.orEmpty(),
            image = image.orEmpty(),
            publisher = Publisher(
                id = publisherId ?: return null,
                icon = publisherIcon.orEmpty(),
                publisherName = publisherName.orEmpty()
            )
        )
    }
}

@Parcelize
data class Article(
    val id: String,
    val title: String,
    val url: String,
    val description: String,
    val image: String,
    val publisher: Publisher,
) : Parcelable