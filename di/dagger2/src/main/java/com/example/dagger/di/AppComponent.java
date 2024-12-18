package com.example.dagger.di;

import com.example.dagger.App;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {AndroidInjectionModule.class,
        AppModel.class,
})
public interface AppComponent {
    void inject(App app);
}
