package com.example.dagger.di;

import com.example.dagger.Student;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityModule {
    @Provides
    public Student provideStudent(){
        return new Student();
    }
}
