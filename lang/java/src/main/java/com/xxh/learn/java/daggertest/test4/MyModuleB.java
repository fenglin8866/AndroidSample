package com.xxh.learn.java.daggertest.test4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;

@Module
class MyModuleB {
    @Provides
    @ElementsIntoSet
    static Set<String> provideSomeStrings(DepA depA, DepB depB) {
        return new HashSet<String>(Arrays.asList("DEF", "GHI"));
    }
}
