package com.example.dagger3.data;

public class Car {
    private final Engine engine;

    private String name;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }
}
