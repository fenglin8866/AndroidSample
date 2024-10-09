package com.xxh.learn.java.base.base3.dagger7;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = PadModule.class)
public interface PadComponent {
    void inject(Pad pad);

    @Subcomponent.Factory
    interface Factory {

        PadComponent create(@BindsInstance Pad instance);
    }
}
