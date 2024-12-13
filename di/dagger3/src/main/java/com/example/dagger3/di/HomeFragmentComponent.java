package com.example.dagger3.di;

import com.example.dagger3.MainFragment;

import dagger.Subcomponent;

@Subcomponent
public interface HomeFragmentComponent {

    void inject(MainFragment homeFragment);

    @Subcomponent.Builder
    interface Builder {
        HomeFragmentComponent build();
    }
}
