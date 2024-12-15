package com.example.dagger3.di;

import com.example.dagger3.HomeContract;
import com.example.dagger3.HomeFragment;
import com.example.dagger3.HomePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface HomeActivityModule {

    @FragmentScoped
    @ContributesAndroidInjector
    HomeFragment provideHomeFragment();

    @Binds
    HomeContract.IHomePresenter providePresenter(HomePresenter homePresenter);

}
