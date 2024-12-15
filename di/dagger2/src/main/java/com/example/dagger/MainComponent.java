package com.example.dagger;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {AndroidInjectionModule.class})
public interface MainComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    public interface Factory extends AndroidInjector.Factory<MainActivity> {

    }
}
