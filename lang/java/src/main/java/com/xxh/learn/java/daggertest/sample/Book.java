package com.xxh.learn.java.daggertest.sample;

import javax.inject.Inject;

public class Book {
    private String name;
    @Inject
    public Book(String name) {
    }

    public void read(){
        System.out.println("看书:"+name);
    }
}
