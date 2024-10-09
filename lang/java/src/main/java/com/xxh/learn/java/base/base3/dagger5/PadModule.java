package com.xxh.learn.java.base.base3.dagger5;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class PadModule {

    @Provides
    public MaxCPU providerMaxCPU() {
        return new MaxCPU();
    }

    @Named("a")
    @Provides
    public Battery providerBattery() {
        return new Battery();
    }
}
