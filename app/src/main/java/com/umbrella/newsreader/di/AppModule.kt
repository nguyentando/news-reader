package com.umbrella.newsreader.di

import com.umbrella.newsreader.util.SavedStateHandleManager
import com.umbrella.newsreader.util.SavedStateHandleManagerImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideSavedStateHandleManager(): SavedStateHandleManager {
        return SavedStateHandleManagerImpl()
    }
}