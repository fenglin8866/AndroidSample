package com.xxh.learn.java.daggertest.test2.auto;

import com.xxh.learn.java.daggertest.test2.CarModel;
import com.xxh.learn.java.daggertest.test2.Wheel;

import dagger.internal.Factory;

public class CarModelProvideWheelFactory implements Factory<Wheel> {

    private final CarModel carModel;

    public CarModelProvideWheelFactory(CarModel carModel) {
        this.carModel = carModel;
    }

    public static CarModelProvideWheelFactory create(CarModel carModel) {
        return new CarModelProvideWheelFactory(carModel);
    }

    @Override
    public Wheel get() {
        return provideWheel(carModel);
    }

    public static Wheel provideWheel(CarModel carModel) {
        return carModel.provideWheel();
    }

}
