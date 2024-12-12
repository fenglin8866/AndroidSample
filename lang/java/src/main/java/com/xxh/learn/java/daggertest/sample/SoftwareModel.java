package com.xxh.learn.java.daggertest.sample;

import dagger.Module;
import dagger.Provides;

@Module
public class SoftwareModel {
    private String name;

    public SoftwareModel(String name) {
        this.name = name;
    }

    @Provides
    public Software providerSoftware(){
        return new Software(name);
    }

}
