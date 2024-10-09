package com.xxh.learn.java.base.base3.dagger4.dagger;

public class AppBean {
    private String name;

    public AppBean() {
        name="AppBean";
    }

    @Override
    public String toString() {
        return "AppBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
