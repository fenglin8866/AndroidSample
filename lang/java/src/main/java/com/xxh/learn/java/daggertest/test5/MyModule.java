package com.xxh.learn.java.daggertest.test5;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class MyModule {
    @Provides
    @IntoMap
    @StringKey("foo")
    static Long provideFooValue(){
        return 100L;
    }

    @Provides @IntoMap
    @ClassKey(Thing.class)
    static String provideThingValue() {
        return "value for Thing";
    }
}
