package com.xxh.learn.java.daggertest.test;

public interface ToolComponent {
    void inject(Tool tool);

    Car car();
}
