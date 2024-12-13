package com.example.dagger3.data;

import java.util.UUID;

import javax.inject.Inject;
import javax.inject.Singleton;

//@Singleton
public class CarRepository implements CarResource {

    @Inject
    public CarRepository(){}

    @Override
    public Car getRandomCar() {
        String name= UUID.randomUUID().toString().substring(0,4);
        int cylinders= (int) (Math.random()*10);
        Car car=new Car(new Engine(cylinders));
        car.setName(name);
        return car;
    }
}
