package com.xxh.learn.java.base.base3.dagger3;

import javax.inject.Inject;

public class Tesla extends Car {
    @Inject
    public Tesla() {
        name="tesla";
    }

    @Override
    public String toString() {
        return "Tesla{" +
                "name='" + name + '\'' +
                '}';
    }
}
