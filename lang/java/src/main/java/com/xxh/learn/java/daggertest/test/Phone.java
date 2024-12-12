package com.xxh.learn.java.daggertest.test;

public class Phone {
    private Pen pen;

    public Phone(Pen pen) {
        this.pen = pen;
    }

    public void use() {
        System.out.println("看手机");
    }
}
