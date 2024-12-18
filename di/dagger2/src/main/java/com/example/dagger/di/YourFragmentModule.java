package com.example.dagger.di;

import com.example.dagger.School;

import dagger.Module;
import dagger.Provides;

@Module
public class YourFragmentModule {

    @Provides
    School provideSchool() {
        return new School();
    }
}
