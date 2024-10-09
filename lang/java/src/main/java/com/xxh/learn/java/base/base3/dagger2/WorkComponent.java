package com.xxh.learn.java.base.base3.dagger2;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = MouseModule.class)
public interface WorkComponent {
    void injectWork(Work work);
}
