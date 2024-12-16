package com.example.dagger;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = YourFragmentSubcomponent.class)
abstract class YourFragmentModule {
    @Binds
    @IntoMap
    @ClassKey(YourFragment.class)
    abstract AndroidInjector.Factory<?>
    bindYourFragmentInjectorFactory(YourFragmentSubcomponent.Factory factory);

    @Provides
    static School provideSchool(){
        return new School();
    }
}
