package com.example.dagger3.di;

import com.example.dagger3.data.CarResource;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    CarResource getCarResource();

    HomeActivityComponent.Builder homeActivityComponent();

    @Component.Builder
    interface Builder {
        AppComponent build();
    }

}
