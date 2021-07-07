package com.umbrella.domain.usecase.article

import com.umbrella.data.model.article.ArticleHeader
import com.umbrella.data.repository.ArticleRepository
import com.umbrella.data.util.getDataNonNull
import com.umbrella.domain.UseCase
import com.umbrella.domain.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetArticleListParam()
class GetArticleListUseCase @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val articleRepository: ArticleRepository
) : UseCase<GetArticleListParam, List<ArticleHeader>>(dispatcher) {
    override suspend fun execute(parameters: GetArticleListParam): List<ArticleHeader> {
        return articleRepository.getArticleList().getDataNonNull()
    }
}