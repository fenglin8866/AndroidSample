package com.xxh.learn.java.base.base3.dagger5;

import javax.inject.Inject;

public class Phone {
    @Inject
    public Screen screen;
    @Inject
    public CPU cpu;
    @Inject
    public Battery battery;

    public Phone() {
        DaggerPhoneComponent.create().inject(this);
    }
}