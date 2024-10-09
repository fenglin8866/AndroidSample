package com.xxh.learn.java.base.base3.dagger4.dagger;

import javax.inject.Inject;

public class Application {

    @Inject
    public AppBean appBean;

    public AppComponent appComponent;

    private Application() {
        appComponent = DaggerAppComponent.create();
        appComponent.inject(this);
    }

    public static Application getInstance() {
        return new Application();
    }
}
