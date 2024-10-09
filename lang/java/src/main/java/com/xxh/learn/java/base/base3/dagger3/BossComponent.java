package com.xxh.learn.java.base.base3.dagger3;

import dagger.BindsInstance;
import dagger.Component;

@Component
public interface BossComponent {

    void injectBoss(CarShop shop);

    String getTag();

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder tag(String tag);
        BossComponent build();
    }

}
