package com.xxh.learn.java.daggertest;

import dagger.internal.Provider;

public final class Cpu_Factory implements Provider<Cpu> {


    public static Cpu_Factory create() {
        return Cpu_FactoryHolder.INSTANCE;
    }

    @Override
    public Cpu get() {
        return newInstance();
    }

    private static Cpu newInstance() {
        return new Cpu();
    }


    private static final class Cpu_FactoryHolder {
        private static final Cpu_Factory INSTANCE = new Cpu_Factory();
    }

}
