package com.xxh.learn.java.daggertest.sample2;

import javax.inject.Inject;

public class Relaxation {
    @Inject
    public Relaxation() {
        System.out.println("创建 Relaxation");
    }

    public void relax() {
        System.out.println("休闲一下");
    }
}
