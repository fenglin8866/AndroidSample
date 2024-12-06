package com.xxh.learn.java.daggertest.test.dagger;


import com.xxh.learn.java.daggertest.test.Engine;
import com.xxh.learn.java.daggertest.test.ToolModel;

import dagger.internal.Factory;

public class ToolModelEngineFactory implements Factory<Engine> {
    private final ToolModel toolModel;

    public ToolModelEngineFactory(ToolModel toolModel) {
        this.toolModel = toolModel;
    }

    public static ToolModelEngineFactory create(ToolModel toolModel) {
        return new ToolModelEngineFactory(toolModel);
    }


    @Override
    public Engine get() {
        return providerEngine(toolModel);
    }


    public static Engine providerEngine(ToolModel toolModel){
        return toolModel.providerEngine();
    }
}
