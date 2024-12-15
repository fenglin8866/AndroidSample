package com.example.dagger;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;

@Module(subcomponents = {MainComponent.class})
public abstract class MainModel {
    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<? >
        bindYourActivityInjectorFactory(MainComponent.Factory factory);
    @Singleton
    @Provides
    static Student provideStudent(){
        return new Student();
    }
}
