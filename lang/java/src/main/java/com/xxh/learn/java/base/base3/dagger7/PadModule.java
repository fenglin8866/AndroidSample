package com.xxh.learn.java.base.base3.dagger7;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class PadModule {

    @Provides
    public Battery providerBattery() {
        return new Battery();
    }
}
