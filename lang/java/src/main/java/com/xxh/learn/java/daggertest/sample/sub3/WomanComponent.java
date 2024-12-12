package com.xxh.learn.java.daggertest.sample.sub3;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent
public interface WomanComponent {
    void inject(Woman woman);

    @Subcomponent.Factory
    interface Factory {
        WomanComponent create(@BindsInstance WomanFeature feature);
    }
}
