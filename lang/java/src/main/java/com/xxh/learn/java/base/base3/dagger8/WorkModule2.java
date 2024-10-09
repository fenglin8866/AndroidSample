package com.xxh.learn.java.base.base3.dagger8;

import dagger.Module;
import dagger.Provides;

@Module()
public class WorkModule2 {
    /**
     * 必须是目标类中的注入类型，不能是子类。
     * @return
     */
    @Provides
    Tool ProvideComputer() {
        return new Computer();
    }
}
