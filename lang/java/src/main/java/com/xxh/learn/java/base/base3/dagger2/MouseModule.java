package com.xxh.learn.java.base.base3.dagger2;

import dagger.Module;
import dagger.Provides;

import javax.inject.Named;

@Module
public class MouseModule {
    @Named("AA")
    @Provides
    public Mouse provideMouse(){
        return new Mouse();
    }

    @Named("BB")
    @Provides
    public Mouse provideMouse2(){
        return new Mouse();
    }
}
