package com.xxh.learn.composite.di

import android.content.Context
import com.xxh.learn.composite.database.AppDatabase
import com.xxh.learn.composite.database.schedule.ScheduleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(Singleton::class)
@Module
class ScheduleDaoModule {

    @Singleton
    @Provides
    fun provideScheduleDao(db: AppDatabase): ScheduleDao {
        return db.scheduleDao()
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

}