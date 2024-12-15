package com.example.dagger3.di;

import com.example.dagger3.CarApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * CarResource通过组件注入传达给Activity和Fragment，不需要暴露任何对象
 * AndroidSupportInjectionModule提供一些注入的集合，对应不确定的Android框架组件
 */
@Singleton
@Component(modules = {AppModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<CarApp> {

}
