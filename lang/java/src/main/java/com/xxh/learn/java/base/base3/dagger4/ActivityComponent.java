package com.xxh.learn.java.base.base3.dagger4;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(Activity activity);
}
