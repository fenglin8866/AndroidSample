package com.xxh.learn.java.daggertest.sample.sub2;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = {ManModel.class})
public interface ManComponent {
    void inject(Man man);

    @Subcomponent.Builder
    interface Builder{

        Builder manModel(ManModel manModel);

        ManComponent build();
    }

}
