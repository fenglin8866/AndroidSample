package com.example.dagger.di;

import com.example.dagger.YourFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {YourFragmentModule.class})
public interface YourFragmentSubcomponent extends AndroidInjector<YourFragment> {

    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<YourFragment> {
    }
}
