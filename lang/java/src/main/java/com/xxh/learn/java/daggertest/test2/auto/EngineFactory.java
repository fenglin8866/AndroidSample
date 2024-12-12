package com.xxh.learn.java.daggertest.test2.auto;

import com.xxh.learn.java.daggertest.test2.Engine;

import dagger.internal.Factory;

public class EngineFactory implements Factory<Engine> {

    private static final class Holder {
        private static final EngineFactory INSTANCE = new EngineFactory();
    }

    public static EngineFactory create() {
        return Holder.INSTANCE;
    }

    @Override
    public Engine get() {
        return newInstance();
    }

    public static Engine newInstance() {
        return new Engine();
    }

}
