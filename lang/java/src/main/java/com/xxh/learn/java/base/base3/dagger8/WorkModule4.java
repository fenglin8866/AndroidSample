package com.xxh.learn.java.base.base3.dagger8;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.Multibinds;

import java.util.Map;

@Module
public abstract class WorkModule4 {

    @Multibinds
    abstract Map<String,Tool> toolMap();

    @Binds
    abstract Tool bindComputer(Computer computer);

}
