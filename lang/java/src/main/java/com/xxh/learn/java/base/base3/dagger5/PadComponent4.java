package com.xxh.learn.java.base.base3.dagger5;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = PadModule.class)
public interface PadComponent4 {
    void injectPad(Pad pad);

    MaxCPU maxCPU();

    @Subcomponent.Builder
    interface Builder{

        Builder padModule(PadModule module);

        PadComponent4 build();
    }

}
