package com.xxh.learn.java.daggertest.test2;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {CarModel.class}, dependencies = {SoftwareComponent.class})
public interface CarComponent {
    void inject(Car car);

    NewEnergyCarComponent newEnergyCarComponent();
}
