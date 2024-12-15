package com.xxh.learn.java.daggertest.test4;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
public class MyModuleC {
    @Provides
    @IntoSet
    @MyQualifier
    static Foo provideOneFoo(DepA depA,DepB depB){
        return  new Foo(depA,depB);
    }

}
