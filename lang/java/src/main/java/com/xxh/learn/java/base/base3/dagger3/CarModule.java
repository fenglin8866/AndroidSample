package com.xxh.learn.java.base.base3.dagger3;

import dagger.Binds;
import dagger.Module;

import javax.inject.Named;

@Module
public abstract class CarModule {
    @Binds
    @Named("A")
    abstract Car provideCarA(Tesla tesla);
}
