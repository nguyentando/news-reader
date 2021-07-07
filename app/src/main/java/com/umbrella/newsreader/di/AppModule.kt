package com.umbrella.newsreader.di

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import com.umbrella.newsreader.R
import com.umbrella.newsreader.databinding.ItemArticleBinding
import com.umbrella.newsreader.util.SavedStateHandleManager
import com.umbrella.newsreader.util.SavedStateHandleManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideSavedStateHandleManager(): SavedStateHandleManager {
        return SavedStateHandleManagerImpl()
    }

    @Singleton
    @Provides
    @Named("itemArticle")
    fun provideItemArticleView(@ApplicationContext context: Context): View {
        return LayoutInflater.from(context).inflate(R.layout.item_article, null)
    }

    @Singleton
    @Provides
    @Named("itemArticlePrimaryTextPrecomputedParam")
    fun provideItemArticleTextPrimaryPrecomputedParam(@Named("itemArticle") vg: View): PrecomputedTextCompat.Params {
        val binding = ItemArticleBinding.bind(vg)
        return TextViewCompat.getTextMetricsParams(binding.tvPrimary)
    }

    @Singleton
    @Provides
    @Named("itemArticleSecondaryTextPrecomputedParam")
    fun provideItemArticleTextSecondaryPrecomputedParam(@Named("itemArticle") vg: View): PrecomputedTextCompat.Params {
        val binding = ItemArticleBinding.bind(vg)
        return TextViewCompat.getTextMetricsParams(binding.tvSecondary)
    }
}