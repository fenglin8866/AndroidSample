package com.example.dagger3.di;

import androidx.fragment.app.Fragment;

import com.example.dagger3.HomeContract;
import com.example.dagger3.HomePresenter;
import com.example.dagger3.MainFragment;

import dagger.Binds;
import dagger.Module;

@Module(subcomponents = HomeFragmentComponent.class)
public interface HomeActivityModule {

    @Binds
    Fragment provideHomeFragment(MainFragment fragment);

    @Binds
    HomeContract.IHomePresenter providePresenter(HomePresenter homePresenter);

}
