package com.xxh.learn.java.base.base3.dagger5;

import com.xxh.learn.java.base.base3.dagger5.dependencies.Battery;
import com.xxh.learn.java.base.base3.dagger5.dependencies.CPU;
import com.xxh.learn.java.base.base3.dagger5.dependencies.Ram;
import com.xxh.learn.java.base.base3.dagger5.dependencies.Screen;

import dagger.Component;

@PhoneScope
@Component(modules = {PhoneModule.class, PhoneModule2.class})
public interface PhoneComponent {
    void inject(Phone phone);

    Screen getScreen();

    Battery getBattery();

    Ram getRam();

    CPU getCPU();

    PadComponent2 padComponent2();

    PadComponent3.Builder padComponent3Builder();

    PadComponent4.Builder padComponent4Builder();


    PadComponent5.Factory padComponent5Factory();
}
