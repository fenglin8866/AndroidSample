package com.xxh.learn.java.daggertest.sample.sub4;

import com.xxh.learn.java.daggertest.sample.DaggerSoftwareComponent;
import com.xxh.learn.java.daggertest.sample.DaggerToolComponent;
import com.xxh.learn.java.daggertest.sample.SoftwareModel;

import javax.inject.Inject;

public class Human {
    @Inject
    public Foo foo;

    public Human(){
        DaggerToolComponent.builder().softwareComponent(DaggerSoftwareComponent.builder().softwareModel(new SoftwareModel("飞书"))
                .build()).build().HumanComponentBuilder().foo(new Foo()).build().inject(this);
    }

    public void run(){
        foo.run();
    }
}
