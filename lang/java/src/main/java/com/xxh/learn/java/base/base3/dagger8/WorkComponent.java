package com.xxh.learn.java.base.base3.dagger8;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = WorkModule3.class)
public interface WorkComponent {
    void injectWork(Work work);

}
