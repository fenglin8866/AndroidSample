package com.xxh.learn.java.daggertest.sample2;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.Reusable;

@Module
public class WorkModule {

    @Singleton
    @Provides
    public Desk provideDesk(){
        return new Desk();
    }

    @Reusable
    @Provides
    public Keyboard provideKeyboard(){
        return new Keyboard();
    }

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

    /**
     * 必须是目标类中的注入类型，不能是子类。
     */
    @Named("Macbook")
    @Provides
    public Computer provideMacbook(){
        return new Macbook();
    }

    @Named("MacMini")
    @Provides
    public Computer provideMacMini(){
        return new MacMini();
    }
}
