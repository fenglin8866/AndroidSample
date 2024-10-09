package com.xxh.learn.java.base.base3.dagger1;

import dagger.Component;

/**
 * 1.只能是接口或抽象类
 * 2.injectXXX(XXX)会自动注入所有的依赖对象
 */
@Component(modules = {CarPartModule.class, DoorModule.class})
public interface CarComponent {
    void injectCar(Car car);

    Wheel generateEngine();
}
