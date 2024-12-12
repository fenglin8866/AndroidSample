package com.xxh.learn.java.daggertest.sample2;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;

public class Work {
    @Named("AA")
    @Inject
    public Mouse mouse1;
    @Named("BB")
    @Inject
    public Mouse mouse2;

    @Inject
    public Keyboard keyboard2;

    @Named("Macbook")
    @Inject
    public Computer computer;

    @Named("MacMini")
    @Inject
    public Computer computer2;

    @Inject
    public Lazy<Relaxation> relaxationLazy;


    public Work() {
        DaggerWorkComponent.create().injectWork(this);
    }

    public void test() {
        if (keyboard2 != null) {
            System.out.println("keyboard2" + keyboard2);
        }
        computer.work();
        computer2.work();
        relaxationLazy.get().relax();
    }

}
