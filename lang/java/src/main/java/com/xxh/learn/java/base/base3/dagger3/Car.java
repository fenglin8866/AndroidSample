package com.xxh.learn.java.base.base3.dagger3;

import javax.inject.Inject;

public class Car {
    String name="byd";
    Engine engine;


    public Car(Engine engine) {
        this.engine = engine;
    }

    @Inject
    public Car() {
    }

    public String getName() {
        return name;
    }

    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
