package com.example.dagger;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = YourActivitySubcomponent.class)
abstract class YourActivityModule {
    @Binds
    @IntoMap
    @ClassKey(YourActivity.class)
    abstract AndroidInjector.Factory<?>
    bindYourAndroidInjectorFactory(YourActivitySubcomponent.Factory factory);

    @Provides
    static Home provideHome(){
        return new Home();
    }
}
