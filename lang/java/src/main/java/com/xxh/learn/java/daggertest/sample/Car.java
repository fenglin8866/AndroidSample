package com.xxh.learn.java.daggertest.sample;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println("开车");
    }
}
