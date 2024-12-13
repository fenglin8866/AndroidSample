package com.example.dagger3.di;

import com.example.dagger3.MainActivity;

import dagger.Subcomponent;

@Subcomponent(modules = HomeActivityModule.class)
public interface HomeActivityComponent {

    void inject(MainActivity activity);

    HomeFragmentComponent.Builder homeFragmentComponent();

    @Subcomponent.Builder
    interface Builder {
        HomeActivityComponent build();
    }
}