package com.xxh.learn.java.daggertest.sample.sub3;

import com.xxh.learn.java.daggertest.sample.DaggerSoftwareComponent;
import com.xxh.learn.java.daggertest.sample.DaggerToolComponent;
import com.xxh.learn.java.daggertest.sample.Phone;
import com.xxh.learn.java.daggertest.sample.SoftwareModel;
import com.xxh.learn.java.daggertest.sample.sub2.ManModel;

import javax.inject.Inject;

public class Woman {
    @Inject
    public WomanFeature feature;

    @Inject
    public Phone phone;

    public Woman() {
        DaggerToolComponent.builder().softwareComponent(DaggerSoftwareComponent.builder().softwareModel(new SoftwareModel("飞书"))
                .build()).build().womanComponentFactory().create(new WomanFeature()).inject(this);
    }

    public void run(){
        feature.run();
        phone.use();
    }
}
