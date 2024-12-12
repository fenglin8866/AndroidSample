package com.xxh.learn.java.daggertest.test2.auto;

import com.xxh.learn.java.daggertest.test2.CarModel;
import com.xxh.learn.java.daggertest.test2.FuelTank;

import dagger.internal.Factory;

public class CarModelProvideFuelTankFactory implements Factory<FuelTank> {

    private final CarModel carModel;

    public CarModelProvideFuelTankFactory(CarModel carModel) {
        this.carModel = carModel;
    }

    public static CarModelProvideFuelTankFactory create(CarModel carModel) {
        return new CarModelProvideFuelTankFactory(carModel);
    }

    @Override
    public FuelTank get() {
        return provideFuelTank(carModel);
    }

    public static FuelTank provideFuelTank(CarModel carModel) {
        return carModel.provideFuelTank();
    }

}
