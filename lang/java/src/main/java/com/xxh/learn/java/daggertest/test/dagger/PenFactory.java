package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.Pen;

import dagger.internal.Factory;

public class PenFactory implements Factory<Pen> {

    private static final class Holder {
        private static final PenFactory INSTANCE = new PenFactory();
    }

    //静态内部类构建对象
    public static PenFactory create() {
        return Holder.INSTANCE;
    }

    @Override
    public Pen get() {
        return newInstance();
    }

    public static Pen newInstance() {
        return new Pen();
    }

}
