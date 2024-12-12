package com.xxh.learn.java.daggertest.sample.sub;

import com.xxh.learn.java.daggertest.sample.Car;
import com.xxh.learn.java.daggertest.sample.DaggerSoftwareComponent;
import com.xxh.learn.java.daggertest.sample.DaggerToolComponent;
import com.xxh.learn.java.daggertest.sample.House;
import com.xxh.learn.java.daggertest.sample.Phone;
import com.xxh.learn.java.daggertest.sample.SoftwareModel;
import com.xxh.learn.java.daggertest.sample.Tool;

import javax.inject.Inject;

public class People {

    @Inject
    public Header header;
    @Inject
    public Body body;
    @Inject
    public House house;
    @Inject
    public Phone phone;
    @Inject
    public Car car;

    public People(){
        DaggerToolComponent.builder().softwareComponent(DaggerSoftwareComponent.builder().softwareModel(new SoftwareModel("飞书"))
                .build()).build().peopleComponent().inject(this);
    }

    public void run(){
        header.header();
        body.body();
        house.sleep();
        phone.use();
        car.drive();
    }

}
