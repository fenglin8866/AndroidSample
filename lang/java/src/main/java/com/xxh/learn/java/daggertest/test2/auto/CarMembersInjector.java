package com.xxh.learn.java.daggertest.test2.auto;

import com.xxh.learn.java.daggertest.test2.Brake;
import com.xxh.learn.java.daggertest.test2.Car;
import com.xxh.learn.java.daggertest.test2.Engine;
import com.xxh.learn.java.daggertest.test2.FuelTank;
import com.xxh.learn.java.daggertest.test2.Software;
import com.xxh.learn.java.daggertest.test2.Wheel;

import dagger.MembersInjector;
import dagger.internal.Provider;

public class CarMembersInjector implements MembersInjector<Car> {
    private final Provider<Engine> engineProvider;
    private final Provider<Wheel> wheelProvider;
    private final Provider<FuelTank> fuelTankProvider;
    private final Provider<Brake> brakeProvider;
    private final Provider<Software> softwareProvider;

    public CarMembersInjector(Provider<Engine> engineProvider, Provider<Wheel> wheelProvider, Provider<FuelTank> fuelTankProvider, Provider<Brake> brakeProvider, Provider<Software> softwareProvider) {
        this.engineProvider = engineProvider;
        this.wheelProvider = wheelProvider;
        this.fuelTankProvider = fuelTankProvider;
        this.brakeProvider = brakeProvider;
        this.softwareProvider = softwareProvider;
    }

    public static CarMembersInjector create(Provider<Engine> engineProvider, Provider<Wheel> wheelProvider, Provider<FuelTank> fuelTankProvider, Provider<Brake> brakeProvider, Provider<Software> softwareProvider) {
        return new CarMembersInjector(engineProvider, wheelProvider, fuelTankProvider, brakeProvider, softwareProvider);
    }


    @Override
    public void injectMembers(Car instance) {
        injectEngine(instance, engineProvider.get());
        injectWheel(instance, wheelProvider.get());
        injectBrake(instance, brakeProvider.get());
        injectFueTank(instance, fuelTankProvider.get());
        injectSoftware(instance,softwareProvider.get());
    }


    public static void injectEngine(Car car, Engine engine) {
        car.engine = engine;
    }

    public static void injectWheel(Car car, Wheel wheel) {
        car.wheel = wheel;
    }

    public static void injectBrake(Car car, Brake brake) {
        car.brake = brake;
    }

    public static void injectFueTank(Car car, FuelTank fuelTank) {
        car.fuelTank = fuelTank;
    }

    public static void injectSoftware(Car car, Software software) {
        car.software = software;
    }

}
