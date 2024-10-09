package com.xxh.learn.java.dagger.mode1;

import javax.inject.Inject;

public class TestConstructorDI {
    @Inject
    Car2 car2;

    public void test() {
        test0();
        test1();
        test2();
    }

    private void test0() {
        Engine engine = DaggerEngineComponent.create().getEngine();
        Car car = new Car(engine);
        car.run();
    }

    private void test1() {
        Car1 car1 = new Car1();
        car1.run();
    }

    private void test2() {
        car2 = DaggerCar2Component.create().getCar2();
        car2.run();
    }
}
