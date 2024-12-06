package com.xxh.learn.java.daggertest.test;

public class ToolModel {

    public Car providerCar(Engine engine){
        return new Car(engine);
    }

    public Engine providerEngine(){
        return new Engine();
    }

    public House providerHouse(){
        return new House();
    }

}
