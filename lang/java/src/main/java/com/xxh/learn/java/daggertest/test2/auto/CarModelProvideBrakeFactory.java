package com.xxh.learn.java.daggertest.test2.auto;

import com.xxh.learn.java.daggertest.test2.Brake;
import com.xxh.learn.java.daggertest.test2.CarModel;

import dagger.internal.Factory;

public class CarModelProvideBrakeFactory implements Factory<Brake> {

    private final CarModel carModel;

    public CarModelProvideBrakeFactory(CarModel carModel) {
        this.carModel = carModel;
    }

    public static CarModelProvideBrakeFactory create(CarModel carModel) {
        return new CarModelProvideBrakeFactory(carModel);
    }

    @Override
    public Brake get() {
        return provideBrake(carModel);
    }

    public static Brake provideBrake(CarModel carModel) {
        return carModel.provideBrake();
    }

}
