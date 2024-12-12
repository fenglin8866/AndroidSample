package com.xxh.learn.java.daggertest.test2;

import javax.inject.Inject;

public class Car {
    @Inject
    public Engine engine;
    @Inject
    public Wheel wheel;
    @Inject
    public Brake brake;
    @Inject
    public FuelTank fuelTank;
    @Inject
    public Software software;

}
