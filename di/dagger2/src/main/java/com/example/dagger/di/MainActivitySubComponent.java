package com.example.dagger.di;

import com.example.dagger.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * 为什么不需要引用AndroidInjectionModule.class？
 * 因为父Component已经引该模块，SubComponent可以引用父类内对象。
 */
@Subcomponent(modules = {MainActivityModule.class})
public interface MainActivitySubComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<MainActivity> {

    }
}
