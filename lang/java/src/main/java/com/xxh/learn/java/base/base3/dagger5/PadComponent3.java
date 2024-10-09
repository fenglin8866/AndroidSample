package com.xxh.learn.java.base.base3.dagger5;

import dagger.Subcomponent;

@Subcomponent(modules = PadModule.class)
public interface PadComponent3 {
    void injectPad(Pad pad);

    @Subcomponent.Builder
    interface Builder{

        Builder padModule(PadModule module);

        PadComponent3 build();
    }
}
