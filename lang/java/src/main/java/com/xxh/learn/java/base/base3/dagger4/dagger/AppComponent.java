package com.xxh.learn.java.base.base3.dagger4.dagger;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(Application application);

    AppBean providerAppBean();

    ActivityComponent activityComponent();
}
