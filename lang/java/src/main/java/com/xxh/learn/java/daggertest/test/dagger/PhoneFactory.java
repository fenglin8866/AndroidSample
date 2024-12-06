package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.Phone;

import dagger.internal.Factory;

public class PhoneFactory implements Factory<Phone> {

    private static final class Holder {
        private static final PhoneFactory INSTANCE = new PhoneFactory();
    }

    public static PhoneFactory create() {
        return Holder.INSTANCE;
    }

    @Override
    public Phone get() {
        return newInstance();
    }

    public static Phone newInstance() {
        return new Phone();
    }

}
