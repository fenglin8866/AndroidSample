package com.xxh.learn.java.base.base3.dagger4.dagger;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    ActivityBean providerActivityBean(){
        return new ActivityBean();
    }
}
