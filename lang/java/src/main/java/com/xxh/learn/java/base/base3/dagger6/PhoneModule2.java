package com.xxh.learn.java.base.base3.dagger6;

import dagger.Module;
import dagger.Provides;

@Module
public class PhoneModule2 {
    @Provides
    Ram providerRam(){
        return new Ram();
    }
}
