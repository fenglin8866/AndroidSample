package com.example.dagger.di;


import com.example.dagger.MainActivity;
import com.example.dagger.YourActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

/**
 * 不需要标注：引用的SubComponent，否则异常。
 */
@Module(subcomponents = {YourActivitySubcomponent.class})
public abstract class AppModel {

   /* @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?>
    bindMainActivityInjectorFactory(MainActivitySubComponent.Factory factory);*/

    /**
     * 使用ContributesAndroidInjector
     * 简化MainActivitySubComponent定义 和 绑定
     * @return
     */
    @ContributesAndroidInjector(modules = {MainActivityModule.class})
    abstract MainActivity mainActivity();

    /**
     * 为什么要注入该实例？
     * 1、简化在Component中定义SubComponent
     * 2、简化在Activity中调用SubComponent的注入
     *
     * @param factory
     * @return
     */
    @Binds
    @IntoMap
    @ClassKey(YourActivity.class)
    abstract AndroidInjector.Factory<?>
    bindYourAndroidInjectorFactory(YourActivitySubcomponent.Factory factory);

}
