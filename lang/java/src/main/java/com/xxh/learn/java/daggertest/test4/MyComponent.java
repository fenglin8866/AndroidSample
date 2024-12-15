package com.xxh.learn.java.daggertest.test4;

import java.util.Set;

import dagger.Component;

@Component(modules = {MyModuleA.class, MyModuleB.class})
public interface MyComponent {
    void inject(Test test);

    //Set<String> strings();
}
