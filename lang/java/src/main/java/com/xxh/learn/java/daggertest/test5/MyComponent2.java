package com.xxh.learn.java.daggertest.test5;

import java.util.Map;

import dagger.Component;

@Component(modules = {MyModule.class})
public interface MyComponent2 {
    Map<String, Long> longsByString();
    Map<Class<?>, String> stringsByClass();
}
