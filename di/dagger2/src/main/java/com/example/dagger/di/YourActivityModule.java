package com.example.dagger.di;

import com.example.dagger.Home;
import com.example.dagger.YourFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {YourFragmentSubcomponent.class})
abstract class YourActivityModule {

    @Binds
    @IntoMap
    @ClassKey(YourFragment.class)
    abstract AndroidInjector.Factory<?>
    bindYourFragmentInjectorFactory(YourFragmentSubcomponent.Factory factory);

    @Provides
    static Home provideHome() {
        return new Home();
    }
}
