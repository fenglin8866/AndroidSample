package com.xxh.learn.java.base.base3.dagger5;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = PadModule.class)
public interface PadComponent5 {
    void inject(Pad pad);

    @Subcomponent.Factory
    interface Factory {

        PadComponent5 create(@BindsInstance Pad instance);
    }
}
