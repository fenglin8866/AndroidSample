package com.xxh.learn.java.base.base3.dagger1;

import javax.inject.Inject;

public class Wheel {
    @Inject
    public Wheel() {
    }
    public String getNumWheel(){
        return "four wheel";
    }
}
