package com.xxh.learn.java.base.base3.dagger7;

import dagger.Component;

@Component(modules = {PhoneModule.class})
public interface PhoneComponent {
    void inject(Phone phone);

   // PadComponent.Factory factory();
}
