package com.umbrella.data.repository.datasource

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
        "image": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg"
      },
      {
        "content_id": 39408736,
        "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
        "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
        "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
        "publisher_id": 20,
        "publisher_name": "WILLIAM SUBERG",
        "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
        "image": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg"
      },
      {
        "content_id": 39408737,
        "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
        "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
        "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
        "publisher_id": 20,
        "publisher_name": "WILLIAM SUBERG",
        "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
        "image": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg"
      }
    ]
  },
  "error_code": 0,
  "error_message": "Success",
  "server_time": 1625497740
}
"""

private const val articleDetail = """
{
  "data": {
    "content": {
      "content_id": 39391287,
      "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
      "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
      "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
      "publisher_id": 20,
      "publisher_name": "WILLIAM SUBERG",
      "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
      "images": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg",
      "body": [
        {
          "type": "image",
          "content": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg",
          "width": 1276,
          "height": 850
        },
        {
          "type": "text",
          "content": "<strong>Bitcoin (BTC) traded at crucial support near ${'$'}33,000 on Monday after a weekend of gains disappeared in hours. </strong>"
        }
      ]
    },
    "content_filter": "1,2",
    "related": {
      "title": "Tin khác",
      "contents": [
        {
          "content_id": 39408735,
          "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
          "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
          "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
          "publisher_id": 20,
          "publisher_name": "WILLIAM SUBERG",
          "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
          "images": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg"
        },
        {
          "content_id": 39408736,
          "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
          "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
          "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
          "publisher_id": 20,
          "publisher_name": "WILLIAM SUBERG",
          "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
          "images": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg"
        },
        {
          "content_id": 39408737,
          "title": "BTC price drops to fill Bitcoin futures gap as focus turns to ${'$'}46.5K bull target",
          "description": "The latest CME futures gap is filled within hours on Monday, with an attractive gap nearer ${'$'}50,000 providing a frame of reference for bulls.",
          "url": "https://cointelegraph.com/news/btc-price-drops-to-fill-bitcoin-futures-gap-as-focus-turns-to-46-5k-bull-target",
          "publisher_id": 20,
          "publisher_name": "WILLIAM SUBERG",
          "publisher_icon": "https://images.cointelegraph.com/images/300_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS9zdG9yYWdlL3VwbG9hZHMvdmlldy84NDc5ZWQyNTliYTNmYjQyNmY4YWZkNWMyMDQzZmNmYi5qcGc=.jpg",
          "images": "https://images.cointelegraph.com/images/1276_aHR0cHM6Ly9zMy5jb2ludGVsZWdyYXBoLmNvbS91cGxvYWRzLzIwMjEtMDcvOTRhOThhNzMtMTMxNC00OGYyLTlhYzQtMzA4Y2ZjYTY4NmY0LmpwZw==.jpg"
        }
      ]
    }
  },
  "error_code": 0,
  "error_message": "Success",
  "server_time": 1625497740
}  
"""
internal class FakeRemoteArticleDataSourceImpl(private val json: Json, private val errorUtil: ErrorUtil) : RemoteArticleDataSource {
    override fun getArticleList(): Result<List<ArticleHeader>> {
        return CallFake.buildSuccess(json.decodeFromString<RestResponse<ArticleListDto>>(articleList)).toResult(errorUtil).map { data ->
            val newList = mutableListOf<ArticleHeader>()
            (1..10).map {
                newList.addAll(data)
            }
            newList
        }
    }

    override fun getArticleDetail(id: String): Result<ArticleDetail> {
        return CallFake.buildSuccess(json.decodeFromString<RestResponse<ArticleDetailDto>>(articleDetail)).toResult(errorUtil)
    }
}