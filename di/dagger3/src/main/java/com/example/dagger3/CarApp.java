package com.example.dagger3;



import com.example.dagger3.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class CarApp extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.create();
    }

}
