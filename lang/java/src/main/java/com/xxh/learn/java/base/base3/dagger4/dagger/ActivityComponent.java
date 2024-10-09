package com.xxh.learn.java.base.base3.dagger4.dagger;

import dagger.Subcomponent;

@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(Activity activity);
}
