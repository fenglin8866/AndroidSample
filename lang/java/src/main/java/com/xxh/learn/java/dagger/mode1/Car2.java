package com.xxh.learn.java.dagger.mode1;

import javax.inject.Inject;

public class Car2 {
    String mName;

    @Inject
    Engine mEngine;

    @Inject
    public Car2(Engine engine){
        mEngine = engine;
    }

    public String getName(){
        return mName;
    }

    Engine getEngine(){
        return mEngine;
    }

    public void run(){
        System.out.println("car2 num:"+mEngine.mCylinderNumbers);
    }

}
