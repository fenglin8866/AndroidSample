package com.xxh.learn.java.daggertest.test2;

import dagger.Component;

@Component(modules = {SoftwareModel.class})
public interface SoftwareComponent {
    Software software();
}
