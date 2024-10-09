package com.xxh.learn.java.base.base3.dagger2;

import com.xxh.learn.java.base.base3.dagger8.Computer;
import com.xxh.learn.java.base.base3.dagger8.Relaxation;

import dagger.Lazy;

import javax.inject.Inject;
import javax.inject.Named;

public class Work {
    @Named("AA")
    @Inject
    public Mouse mouse1;
    @Named("BB")
    @Inject
    public Mouse mouse2;

  //  @Inject
    public Keyboard keyboard1;

    @Inject
    public Keyboard keyboard2;

    @Inject
    public Computer computer;

    @Inject
    public Lazy<Relaxation> relaxationLazy;


    public Work(){
        //DaggerWorkComponent.create().injectWork(this);
        //WorkComponent component= DaggerWorkComponent.builder().foo(new Foo()).build();
        
        //test();
    }

    public void test(){
        if(keyboard1!=null){
            System.out.println("keyboard1"+keyboard1);
        }
        if(keyboard2!=null){
            System.out.println("keyboard2"+keyboard2);
        }
        relaxationLazy.get().relax();
    }

}
