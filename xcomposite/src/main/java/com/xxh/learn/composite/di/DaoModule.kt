package com.xxh.learn.composite.di

import android.content.Context
import com.xxh.learn.composite.db.AppDatabase
import com.xxh.learn.composite.db.ScheduleDao
import com.xxh.learn.composite.db.WordDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DaoModule {

    @Singleton
    @Provides
    fun provideScheduleDao(db: AppDatabase): ScheduleDao {
        return db.scheduleDao()
    }

    @Singleton
    @Provides
    fun provideWordDao(db: AppDatabase): WordDao {
        return db.wordDao()
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

}