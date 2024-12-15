package com.xxh.learn.java.daggertest.test4;

import java.util.function.Consumer;

import javax.inject.Inject;

public class Test {
    @Inject
    public Bar bar;

    public Test() {
        DaggerMyComponent.builder().build().inject(this);
    }

    public void test(){
        bar.getStringSet().forEach(s -> System.out.println("s="+s));
    }
}
