package com.xxh.learn.java.base.base3.dagger5;

import dagger.Subcomponent;

@Subcomponent(modules = PadModule.class)
public interface PadComponent2 {
    void injectPad(Pad pad);

}
