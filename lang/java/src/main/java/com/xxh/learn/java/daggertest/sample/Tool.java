package com.xxh.learn.java.daggertest.sample;


import javax.inject.Inject;

public class Tool {
    @Inject
    public House house;
    @Inject
    public Phone phone;
    @Inject
    public Car car;
    @Inject
    public Book book;

    public Tool() {
        DaggerToolComponent.create().inject(this);
    }

    public void run() {
        book.read();
        house.sleep();
        phone.use();
        car.drive();
    }
}
