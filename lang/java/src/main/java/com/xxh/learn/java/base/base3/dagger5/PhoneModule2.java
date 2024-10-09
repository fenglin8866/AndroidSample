package com.xxh.learn.java.base.base3.dagger5;

import dagger.Module;
import dagger.Provides;

@Module
public class PhoneModule2 {
    @Provides
    Ram providerRam(){
        return new Ram();
    }
}
