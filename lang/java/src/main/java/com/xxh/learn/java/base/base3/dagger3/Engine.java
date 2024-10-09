package com.xxh.learn.java.base.base3.dagger3;

import javax.inject.Inject;

public class Engine {
    private int num;

    @Inject
    public Engine(int num) {
        this.num = num;
    }
}
