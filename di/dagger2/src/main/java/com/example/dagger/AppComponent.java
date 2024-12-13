package com.example.dagger;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class})
public interface AppComponent {
    void inject(App app);
}
