package com.example.dagger;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoSet;

@Module(subcomponents = {MainComponent.class})
public abstract class MainModel {
    @Binds
    @ClassKey(MainActivity.class)
    @IntoSet
    abstract AndroidInjector.Factory<? extends Activity>
        bindYourActivityInjectorFactory(AndroidInjector.Builder builder);
    @Singleton
    @Provides
    static Student provideStudent(){
        return new Student();
    }
}
