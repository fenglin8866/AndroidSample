package com.xxh.learn.java.base.base3.dagger7;


import javax.inject.Inject;
import javax.inject.Named;

public class Pad {

    @Inject
    public Battery battery;


    public Pad() {
        //DaggerPhoneComponent.create().factory().create(this).inject(this);
    }

    public void test(){
        System.out.println(this);
    }


}
