package com.example.dagger3.data;

public class Engine {
    private final int num;

    public Engine(int num) {
        this.num = num;
    }

    public int getCylinderNumbers(){
        return num;
    }
}
