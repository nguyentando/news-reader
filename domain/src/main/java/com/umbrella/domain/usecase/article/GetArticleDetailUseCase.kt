package com.umbrella.domain.usecase.article

import com.umbrella.data.model.article.ArticleDetail
import com.umbrella.data.repository.ArticleRepository
import com.umbrella.data.util.getDataNonNull
import com.umbrella.domain.UseCase
import com.umbrella.domain.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetArticleDetailParam(val id: String)
class GetArticleDetailUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val articleRepository: ArticleRepository
) : UseCase<GetArticleDetailParam, ArticleDetail>(dispatcher) {
    override suspend fun execute(parameters: GetArticleDetailParam): ArticleDetail {
        return articleRepository.getArticleDetail(parameters.id).getDataNonNull()
    }
}