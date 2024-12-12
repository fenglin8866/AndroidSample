package com.xxh.learn.java.daggertest.sample.sub;

import dagger.Subcomponent;

@Subcomponent(modules = PeopleModel.class)
public interface PeopleComponent {
    void inject(People people);
}
