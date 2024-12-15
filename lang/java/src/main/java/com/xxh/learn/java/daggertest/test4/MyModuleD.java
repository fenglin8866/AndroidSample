package com.xxh.learn.java.daggertest.test4;

import java.util.Set;


import dagger.Module;
import dagger.Provides;

@Module
public class MyModuleD {
    @Provides
    static FooSetUser provideFooSetUser(@MyQualifier Set<Foo> foos) {
        return new FooSetUser();
    }
}
