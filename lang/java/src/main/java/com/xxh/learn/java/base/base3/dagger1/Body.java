package com.xxh.learn.java.base.base3.dagger1;

import javax.inject.Inject;

public class Body {
    private String color;

    public Door door;

    @Inject
    public Body(Door door) {
        this.door = door;
    }

    public Body(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
