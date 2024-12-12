package com.xxh.learn.java.daggertest.sample.sub2;

import com.xxh.learn.java.daggertest.sample.Car;
import com.xxh.learn.java.daggertest.sample.DaggerSoftwareComponent;
import com.xxh.learn.java.daggertest.sample.DaggerToolComponent;
import com.xxh.learn.java.daggertest.sample.House;
import com.xxh.learn.java.daggertest.sample.Phone;
import com.xxh.learn.java.daggertest.sample.SoftwareModel;

import javax.inject.Inject;

public class Man {

    @Inject
    public Feature feature;

    @Inject
    public House house;

    @Inject
    public Car car;

    public Man() {
        DaggerToolComponent.builder().softwareComponent(DaggerSoftwareComponent.builder().softwareModel(new SoftwareModel("飞书"))
                .build()).build().manComponentBuilder().manModel(new ManModel("力气大")).build().inject(this);
    }

    public void run(){
        feature.run();
        house.sleep();
        car.drive();
    }

}
