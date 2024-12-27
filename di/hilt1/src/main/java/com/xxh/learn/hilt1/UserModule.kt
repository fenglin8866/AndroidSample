package com.xxh.learn.hilt1

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
class UserModule {

    @Provides
    fun provideUser():User{
        return User("xxh",36)
    }
}