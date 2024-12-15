package com.xxh.learn.java.daggertest.test3;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

@Module
public class CarModel {
    @Provides
    @IntoSet
    Engine provideEngineIntoSet2(){
        return new Engine(2);
    }

    @Provides
    @IntoMap
    @StringKey("3")
    Engine provideEngineIntoMap3(){
        return new Engine(3);
    }

    @Provides
    Engine provideEngine(){
        return new Engine(1);
    }
}
