package com.xxh.learn.java.daggertest;

import dagger.MembersInjector;
import dagger.internal.Provider;

public final class Phone_MembersInjector implements MembersInjector<Phone> {
    private final Provider<Cpu> provider;

    public Phone_MembersInjector(Provider<Cpu> provider) {
        this.provider = provider;
    }

    public static MembersInjector<Phone> create(Provider<Cpu> provider) {
        return new Phone_MembersInjector(provider);
    }


    @Override
    public void injectMembers(Phone instance) {
        phoneInjectMembers(instance, provider.get());
    }


    public static void phoneInjectMembers(Phone instance, Cpu cpu) {
        instance.cpu = cpu;
    }

}
