package com.xxh.learn.java.daggertest.sample;

import dagger.Component;

@Component(modules = {SoftwareModel.class})
public interface SoftwareComponent {
    Software getSoftware();
}
