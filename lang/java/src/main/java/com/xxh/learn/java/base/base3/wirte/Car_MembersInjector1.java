package com.xxh.learn.java.base.base3.wirte;

import com.xxh.learn.java.base.base3.dagger1.*;

import dagger.MembersInjector;
import javax.inject.Provider;;

public final class Car_MembersInjector1 implements MembersInjector<Car> {

    private Provider<Engine> engineProvider;
    private Provider<Wheel> wheelProvider;

    public Car_MembersInjector1(Provider<Engine> engineProvider, Provider<Wheel> wheelProvider) {
        this.engineProvider = engineProvider;
        this.wheelProvider = wheelProvider;
    }

    public static Car_MembersInjector1 create(Provider<Engine> engineProvider, Provider<Wheel> wheelProvider) {
        return new Car_MembersInjector1(engineProvider, wheelProvider);
    }

    @Override
    public void injectMembers(Car instance) {
        injectEngine(instance, engineProvider.get());
        injectWheel(instance, wheelProvider.get());
    }

    public static void injectEngine(Car instance, Engine engine) {
        instance.engine = engine;
    }

    public static void injectWheel(Car instance, Wheel wheel) {
        instance.wheel = wheel;
    }

}
