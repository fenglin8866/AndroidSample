package com.xxh.learn.java.daggertest.test4;

public class Foo {
    private final DepA depA;
    private final DepB depB
            ;

    public Foo(DepA depA, DepB depB) {
        this.depA = depA;
        this.depB = depB;
    }
}
