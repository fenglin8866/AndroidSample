package com.example.android.hilt.di

import com.example.android.hilt.data.LoggerDataSource
import com.example.android.hilt.data.LoggerInMemoryDataSource
import com.example.android.hilt.data.LoggerLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerDataSourceModule {
    @Binds
    @Singleton
    @Database
    abstract fun bindLocalDataSource(impl: LoggerLocalDataSource): LoggerDataSource

    @Binds
    @InMemory
    @Singleton
    abstract fun bindMemoryDataSource(impl: LoggerInMemoryDataSource): LoggerDataSource
}


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Database

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class InMemory