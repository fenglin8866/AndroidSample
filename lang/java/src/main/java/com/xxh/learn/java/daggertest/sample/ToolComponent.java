package com.xxh.learn.java.daggertest.sample;

import dagger.Component;

@Component(modules = {ToolModel.class})
public interface ToolComponent {
    void inject(Tool tool);

    Car car();
}
