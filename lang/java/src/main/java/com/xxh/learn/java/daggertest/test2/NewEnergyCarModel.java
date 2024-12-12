package com.xxh.learn.java.daggertest.test2;

import dagger.Module;
import dagger.Provides;

@Module
public class NewEnergyCarModel {

    @Provides
    public TV provideTV(){
        return new TV();
    }

    @Provides
    public Fridge provideFridge(){
        return new Fridge();
    }

}
