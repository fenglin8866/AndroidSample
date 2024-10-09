package com.xxh.learn.java.base.base3.dagger8;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import dagger.multibindings.StringKey;

@Module()
public class WorkModule3 {
    /**
     * 必须是目标类中的注入类型，不能是子类。
     *
     * @return
     */
    @Provides
    Tool ProvideComputer() {
        return new Computer();
    }

    @Provides
    @IntoSet
    Tool ProvideComputer1() {
        return new Computer();
    }

    @Provides
    @IntoMap
    @StringKey("a")
    Tool ProvideComputer2() {
        return new Computer();
    }

    @Provides
    @IntoMap
    @StringKey("b")
    Tool ProvideComputer3() {
        return new Computer();
    }
}
