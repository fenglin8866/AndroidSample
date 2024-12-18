package com.example.dagger.di;

import com.example.dagger.YourActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {YourActivityModule.class})
public interface YourActivitySubcomponent extends AndroidInjector<YourActivity> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<YourActivity> {
    }
}
