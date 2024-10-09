package com.xxh.learn.java.base.base3.dagger4.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    @Provides
    AppBean providerAppBean() {
        return new AppBean();
    }
}
