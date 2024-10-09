package com.xxh.learn.java.dagger.mode1;

public class Car {
    String mName;

    Engine mEngine;

    public Car(Engine engine){
        mEngine = engine;
    }

    public String getName(){
        return mName;
    }

    Engine getEngine(){
        return mEngine;
    }

    public void run(){
        System.out.println("car num:"+mEngine.mCylinderNumbers);
    }

}
