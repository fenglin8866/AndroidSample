package com.xxh.learn.java.daggertest.sample;

public class Software {
    private String name;

    public Software(String name) {
        this.name = name;
    }

    public void operate() {
        System.out.println(name + "软件执行");
    }
}
