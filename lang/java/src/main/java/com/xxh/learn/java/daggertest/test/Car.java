package com.xxh.learn.java.daggertest.test;

public class Car {
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println("开车");
    }
}

