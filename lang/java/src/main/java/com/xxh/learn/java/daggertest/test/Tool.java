package com.xxh.learn.java.daggertest.test;

public class Tool {
    public House house;
    public Phone phone;
    public Car car;
    public Book book;

    public void run(){
        book.read();
        house.sleep();
        phone.use();
        car.drive();
    }
}
