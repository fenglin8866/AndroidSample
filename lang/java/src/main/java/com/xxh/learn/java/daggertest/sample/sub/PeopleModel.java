package com.xxh.learn.java.daggertest.sample.sub;

import dagger.Module;
import dagger.Provides;

@Module
public class PeopleModel {

    @Provides
    public Header providerHeader(){
        return new Header();
    }

    @Provides
    public Body providerBody(){
        return new Body();
    }

}
