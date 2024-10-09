package com.xxh.learn.java.base.base3.dagger5;

import dagger.Component;

import javax.inject.Singleton;

@PadScope
@Component(dependencies = PhoneComponent.class,modules = PadModule.class)
public interface PadComponent {
    void injectPad(Pad pad);
}
