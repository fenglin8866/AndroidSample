package com.example.dagger;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {MainComponent.class})
public abstract class MainModel {
    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<? >
        bindMainActivityInjectorFactory(MainComponent.Factory factory);
    @Singleton
    @Provides
    static Student provideStudent(){
        return new Student();
    }
}
