package com.xxh.learn.java.daggertest.sample;

import dagger.Module;
import dagger.Provides;

@Module
public class ToolModel {

    @Provides
    public Car providerCar(Engine engine){
        return new Car(engine);
    }

    @Provides
    public Engine providerEngine(){
        return new Engine();
    }

    @Provides
    public House providerHouse(){
        return new House();
    }

}
