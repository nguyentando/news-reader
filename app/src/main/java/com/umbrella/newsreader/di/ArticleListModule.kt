package com.umbrella.newsreader.di

import androidx.core.text.PrecomputedTextCompat
import com.umbrella.domain.di.IoDispatcher
import com.umbrella.newsreader.view.delegate.ArticleListDelegate
import com.umbrella.newsreader.view.delegate.ArticleListDelegateImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named

@Module
@InstallIn(ViewModelComponent::class)
class ArticleListModule {
    @Provides
    fun provideArticleListDelegate(
        @Named("itemArticlePrimaryTextPrecomputedParam") precomputedPrimaryText: PrecomputedTextCompat.Params,
        @Named("itemArticleSecondaryTextPrecomputedParam") precomputedSecondaryText: PrecomputedTextCompat.Params,
        @IoDispatcher ioDispatcher: CoroutineDispatcher,
    ): ArticleListDelegate {
        return ArticleListDelegateImpl(precomputedPrimaryText, precomputedSecondaryText, ioDispatcher)
    }
}