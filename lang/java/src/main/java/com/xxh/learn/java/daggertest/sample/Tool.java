package com.xxh.learn.java.daggertest.sample;

import javax.inject.Inject;

/**
 * 标记需要的依赖对象属性 不能为private
 */
public class Tool {
    @Inject
    public House house;
    @Inject
    public Phone phone;
    @Inject
    public Car car;
    @Inject
    public Book book;
    @Inject
    public Software software;

    public Tool() {
       // DaggerToolComponent.builder().softwareModel(new SoftwareModel("飞书")).build().inject(this);
       // DaggerToolComponent.builder().softwareModel(new SoftwareModel("飞书")).build().inject(this);

        DaggerToolComponent.builder().softwareComponent(DaggerSoftwareComponent.builder().softwareModel(new SoftwareModel("飞书"))
                .build()).build().inject(this);
    }

    public void run() {
        book.read();
        house.sleep();
        phone.use();
        car.drive();
        software.operate();
    }
}
