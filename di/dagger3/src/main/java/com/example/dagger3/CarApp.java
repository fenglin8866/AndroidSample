package com.example.dagger3;

import android.app.Application;

import com.example.dagger3.di.AppComponent;
import com.example.dagger3.di.DaggerAppComponent;

public class CarApp extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().build();
    }

    public AppComponent appComponent() {
        return mAppComponent;
    }
}
