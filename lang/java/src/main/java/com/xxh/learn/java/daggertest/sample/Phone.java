package com.xxh.learn.java.daggertest.sample;

import javax.inject.Inject;

public class Phone {
    private Pen pen;

    @Inject
    public Phone(Pen pen) {
        this.pen=pen;
    }

    public void use() {
        System.out.println("看手机");
    }
}
