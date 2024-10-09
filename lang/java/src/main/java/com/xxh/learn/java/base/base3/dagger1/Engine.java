package com.xxh.learn.java.base.base3.dagger1;

import javax.inject.Inject;

public class Engine {
    public String name;

    @Inject
    public Operation operation;

    @Inject
    public Engine(Brake brake) {
    }

    //@Inject
    public Engine(String name) {
        this.name = name;
    }

    public String rotateSpeed() {
        String str = name + " Engine rotateSpeed 40000";
        System.out.println(str);
        return str;
    }
}
