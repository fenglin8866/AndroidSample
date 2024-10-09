package com.xxh.learn.java.base.base3.dagger3;

import dagger.Component;

@Component(modules = CarModule.class)
public interface CarComponent {

    void inject(CarShop shop);
    /*@Named("A")
    Car getCarA();

    Car getCarB();

    @Subcomponent.Builder
    interface Builder{
        CarComponent build();
    }*/
}
