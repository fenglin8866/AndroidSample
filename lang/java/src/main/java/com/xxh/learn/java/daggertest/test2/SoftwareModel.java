package com.xxh.learn.java.daggertest.test2;

import dagger.Module;
import dagger.Provides;

@Module
public class SoftwareModel {
    @Provides
    public Software provideSoftware(){
        return new Software();
    }
}
