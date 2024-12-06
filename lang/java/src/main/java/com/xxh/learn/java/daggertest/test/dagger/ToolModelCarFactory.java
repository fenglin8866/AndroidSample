package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.Car;
import com.xxh.learn.java.daggertest.test.Engine;
import com.xxh.learn.java.daggertest.test.ToolModel;

import dagger.internal.Factory;
import dagger.internal.Provider;

public class ToolModelCarFactory implements Factory<Car> {
    private final ToolModel toolModel;
    private final Provider<Engine> engineProvider;

    public ToolModelCarFactory(ToolModel toolModel, Provider<Engine> engineProvider) {
        this.toolModel = toolModel;
        this.engineProvider = engineProvider;
    }

    public static ToolModelCarFactory create(ToolModel toolModel, Provider<Engine> engineProvider) {
        return new ToolModelCarFactory(toolModel, engineProvider);
    }


    @Override
    public Car get() {
        return providerCar(toolModel, engineProvider.get());
    }
    //复用性差,无法复用构造函数的工厂方法
   /* public static Car providerCar(ToolModel toolModel){
        return toolModel.providerCar(toolModel.providerEngine());
    }*/

    public static Car providerCar(ToolModel toolModel, Engine engine) {
        return toolModel.providerCar(engine);
    }

}
