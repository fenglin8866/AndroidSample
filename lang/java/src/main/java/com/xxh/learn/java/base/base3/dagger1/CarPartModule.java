package com.xxh.learn.java.base.base3.dagger1;

import dagger.Module;
import dagger.Provides;

@Module
public class CarPartModule {

    private String name;

    public CarPartModule(String name) {
        this.name = name;
    }

    @Provides
    public Led provideLed(){
        return new Led();
    }

    @Provides
    public Decorated provideDecorated(){
        return new Decorated(name);
    }

}
