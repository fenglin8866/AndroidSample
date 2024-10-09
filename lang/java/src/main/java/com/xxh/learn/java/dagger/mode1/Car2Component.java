package com.xxh.learn.java.dagger.mode1;

import dagger.Component;

@Component
public interface Car2Component {
    void inject(Car2 car2);

    Car2 getCar2();
}
