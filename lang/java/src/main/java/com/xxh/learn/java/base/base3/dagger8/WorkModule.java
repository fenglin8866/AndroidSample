package com.xxh.learn.java.base.base3.dagger8;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

import javax.inject.Singleton;

@Module()
public abstract class WorkModule {

    @Binds
    abstract Tool bindComputer(Computer computer);
}
