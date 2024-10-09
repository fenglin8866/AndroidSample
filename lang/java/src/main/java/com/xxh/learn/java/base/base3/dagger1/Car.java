package com.xxh.learn.java.base.base3.dagger1;

import javax.inject.Inject;

/**
 * 标记需要的依赖对象属性 不能为private
 */
public class Car {

    @Inject
    public Led led;

    @Inject
    public Engine engine;

    @Inject
    public Wheel wheel;

    @Inject
    public Body body;

    @Inject
    public Decorated decorated;

    public Car() {
      //  DaggerCarComponent.builder().engineModule(new EngineModule()).build().injectCar(this);
        //wheel=DaggerCarComponent.create().generateEngine();

       // DaggerCarComponent.builder().carPartModule(new CarPartModule("xxh")).build().injectCar(this);
    }

    @Inject
    public void driveSteeringWheel(SteeringWheel steeringWheel){

    }

    public void speed(){
        System.out.println("Car speed "+engine.rotateSpeed()+" "+wheel.getNumWheel());
    }

}
