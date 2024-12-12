package com.xxh.learn.java.daggertest.sample2;

import javax.inject.Inject;

public class Mouse {
    private String name;
    @Inject
    public Mouse(){

    }

    public Mouse(String name){
        this.name=name;
    }
}
