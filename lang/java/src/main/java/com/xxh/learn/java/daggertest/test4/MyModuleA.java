package com.xxh.learn.java.daggertest.test4;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
class MyModuleA {
    @Provides
    @IntoSet
    static String provideOneString(DepA depA, DepB depB) {
        return "ABC";
    }

    @Provides
    @IntoSet
    static String provideOneString2(DepA depA, DepB depB) {
        return "XYZ";
    }
}
