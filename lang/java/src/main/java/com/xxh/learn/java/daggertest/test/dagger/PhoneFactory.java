package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.Pen;
import com.xxh.learn.java.daggertest.test.Phone;

import dagger.internal.Factory;
import dagger.internal.Provider;

public class PhoneFactory implements Factory<Phone> {

    private final Provider<Pen> penProvider;

    public PhoneFactory(Provider<Pen> penProvider) {
        this.penProvider = penProvider;
    }

    public static PhoneFactory create(Provider<Pen> penProvider) {
        return new PhoneFactory(penProvider);
    }

    @Override
    public Phone get() {
        return newInstance(penProvider.get());
    }

    public static Phone newInstance(Pen pen) {
        return new Phone(pen);
    }

}
