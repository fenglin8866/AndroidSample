package com.xxh.learn.java.base.base3.dagger2;

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
