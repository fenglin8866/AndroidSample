package com.xxh.learn.java.daggertest.sample2;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = WorkModule.class)
public interface WorkComponent {
    void injectWork(Work work);

    Desk desk();
}
