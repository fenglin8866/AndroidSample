package com.xxh.learn.java.base.base3.dagger6;


import javax.inject.Inject;
import javax.inject.Named;

public class Pad {

    @Named("a")
    @Inject
    public Battery battery;

    @Inject
    public Screen screen;

    @Inject
    public MaxCPU maxCPU;

    @Inject
    public Ram ram;

    public Pad() {
//        DaggerPadComponent.builder().phoneComponent(DaggerPhoneComponent.create()).build().injectPad(this);
//        DaggerPhoneComponent.create().padComponent2().injectPad(this);
        //DaggerPhoneComponent.create().padComponent3Builder().build().injectPad(this);

    }

    public void test(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Pad{" +
                "battery=" + battery +
                ", screen=" + screen +
                ", maxCPU=" + maxCPU +
                '}';
    }
}
