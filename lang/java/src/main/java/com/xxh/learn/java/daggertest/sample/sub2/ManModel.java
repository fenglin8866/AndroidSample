package com.xxh.learn.java.daggertest.sample.sub2;

import dagger.Module;
import dagger.Provides;

@Module
public class ManModel {
    private String feature;

    public ManModel(String feature) {
        this.feature = feature;
    }

    @Provides
    public Feature providerFeature() {
        return new Feature(feature);
    }


}
