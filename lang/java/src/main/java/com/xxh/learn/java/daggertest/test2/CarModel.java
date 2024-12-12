package com.xxh.learn.java.daggertest.test2;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class CarModel {

    @Provides
    public Brake provideBrake(){
        return new Brake();
    }

    @Singleton
    @Provides
    public Wheel provideWheel(){
        return new Wheel();
    }

    @Reusable
    @Provides
    public FuelTank provideFuelTank(){
        return new FuelTank();
    }
}
