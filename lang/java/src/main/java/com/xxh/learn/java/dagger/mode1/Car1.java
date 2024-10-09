package com.xxh.learn.java.dagger.mode1;

import javax.inject.Inject;

public class Car1 {
    String mName;

    @Inject
    Engine mEngine;

    public Car1(){
        DaggerCar1Component.builder().build().inject(this);
    }


    public String getName(){
        return mName;
    }

    Engine getEngine(){
        return mEngine;
    }

    public void run(){
        System.out.println("car1 num:"+mEngine.mCylinderNumbers);
    }

}
