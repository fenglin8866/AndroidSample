package com.example.dagger;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
@Singleton
@Component(modules = {AndroidInjectionModule.class,
        MainModel.class,
        YourActivityModule.class,
        YourFragmentModule.class
})
public interface AppComponent {
    void inject(App app);
}
