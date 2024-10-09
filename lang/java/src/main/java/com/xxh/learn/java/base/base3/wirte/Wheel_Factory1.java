package com.xxh.learn.java.base.base3.wirte;

import com.xxh.learn.java.base.base3.dagger1.*;

import dagger.internal.Factory;


public final class Wheel_Factory1 implements Factory<Wheel> {
    @Override
    public Wheel get() {
        return newInstance();
    }

    public static Wheel_Factory1 create() {
        return InstanceHolder.INSTANCE;
    }

    public static Wheel newInstance() {
        return new Wheel();
    }

    private static final class InstanceHolder {
        private static final Wheel_Factory1 INSTANCE = new Wheel_Factory1();
    }
}
