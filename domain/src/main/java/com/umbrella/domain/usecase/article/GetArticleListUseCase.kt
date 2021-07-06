package com.umbrella.domain.usecase.article

import com.umbrella.data.model.article.Article
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
) : UseCase<GetArticleListParam, List<Article>>(dispatcher) {
    override suspend fun execute(parameters: GetArticleListParam): List<Article> {
        return articleRepository.getArticleList().getDataNonNull()
    }
}