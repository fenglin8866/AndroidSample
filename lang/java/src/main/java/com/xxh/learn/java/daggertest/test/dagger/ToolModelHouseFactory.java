package com.xxh.learn.java.daggertest.test.dagger;

import com.xxh.learn.java.daggertest.test.House;
import com.xxh.learn.java.daggertest.test.ToolModel;

import dagger.internal.Factory;

public class ToolModelHouseFactory implements Factory<House> {
    private final ToolModel toolModel;

    public ToolModelHouseFactory(ToolModel toolModel) {
        this.toolModel = toolModel;
    }

    //静态方法构建对象
    public static ToolModelHouseFactory create(ToolModel toolModel) {
        return new ToolModelHouseFactory(toolModel);
    }

    @Override
    public House get() {
        return providerHouse(toolModel);
    }

    //外部可直接调用，增加调用方式
    public static House providerHouse(ToolModel toolModel) {
        return toolModel.providerHouse();
    }

}
