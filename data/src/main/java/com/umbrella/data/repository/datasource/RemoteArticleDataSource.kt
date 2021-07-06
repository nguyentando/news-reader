package com.umbrella.data.repository.datasource

import com.umbrella.data.model.RestResponse
import com.umbrella.data.model.article.Article
import com.umbrella.data.model.article.ArticleListDto
import com.umbrella.data.util.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

interface RemoteArticleDataSource {
    fun getArticleList(): Result<List<Article>>
}

private const val articleList = """
    {
  "data": {
    "contents": [
      {
        "content_id": 39408735,
        "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
        "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
        "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
        "publisher_id": 20,
        "publisher_name": "WILLIAM SUBERG",
        "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
        "image": "https://photo-baomoi.zadn.vn/a500x/2021_07_05_119_39408735/61daa46ba7294e771738.jpg"
      },
      {
        "content_id": 39408736,
        "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
        "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
        "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
        "publisher_id": 20,
        "publisher_name": "WILLIAM SUBERG",
        "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
        "image": "https://photo-baomoi.zadn.vn/a500x/2021_07_05_119_39408735/61daa46ba7294e771738.jpg"
      },
      {
        "content_id": 39408737,
        "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
        "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
        "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
        "publisher_id": 20,
        "publisher_name": "WILLIAM SUBERG",
        "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
        "image": "https://photo-baomoi.zadn.vn/a500x/2021_07_05_119_39408735/61daa46ba7294e771738.jpg"
      }
    ]
  },
  "error_code": 0,
  "error_message": "Success",
  "server_time": 1625497740
}
"""

internal class FakeRemoteArticleDataSourceImpl(private val json: Json, private val errorUtil: ErrorUtil) : RemoteArticleDataSource {
    override fun getArticleList(): Result<List<Article>> {
        return CallFake.buildSuccess(json.decodeFromString<RestResponse<ArticleListDto>>(articleList)).toResult(errorUtil).map { data ->
            val newList = mutableListOf<Article>()
            (1..10).map {
                newList.addAll(data)
            }
            newList
        }
    }
}