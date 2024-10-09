package com.xxh.learn.java.base.base3.dagger8;

import javax.inject.Inject;

public class Computer implements Tool{
    @Inject
    public Computer() {
        System.out.println("创建 Computer");
    }

    @Override
    public void work() {

    }
}
