package com.umbrella.data.repository

import com.umbrella.data.repository.datasource.FakeRemoteArticleDataSourceImpl
import com.umbrella.data.repository.datasource.RemoteArticleDataSource
import com.umbrella.data.util.ErrorUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ArticleModule {
    @Singleton
    @Provides
    fun getRemoteArticleDataSource(json: Json, errorUtil: ErrorUtil): RemoteArticleDataSource {
        return FakeRemoteArticleDataSourceImpl(json, errorUtil)
    }

    @Singleton
    @Provides
    fun getArticleRepository(remoteArticleDataSource: RemoteArticleDataSource): ArticleRepository {
        return ArticleRepositoryImpl(remoteArticleDataSource)
    }
}