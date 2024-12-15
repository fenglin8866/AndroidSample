package com.xxh.learn.java.daggertest.test3;

import dagger.Component;

@Component(modules = {CarModel.class})
public interface CarTest3Component {
    void inject(Car car);

}
