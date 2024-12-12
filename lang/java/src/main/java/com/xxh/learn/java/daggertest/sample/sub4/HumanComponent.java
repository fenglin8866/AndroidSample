package com.xxh.learn.java.daggertest.sample.sub4;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent
public interface HumanComponent {
    void inject(Human human);

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder foo(Foo foo);

        HumanComponent build();
    }
}
