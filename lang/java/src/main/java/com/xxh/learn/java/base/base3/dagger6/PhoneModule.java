package com.xxh.learn.java.base.base3.dagger6;

import dagger.Module;
import dagger.Provides;

/**
 * 配置的subcomponents只说明关系，不会影响自动生产的代码
 * 例如PhoneModule2没有配置，PadComponent4中也能获取Ram对象。
 */
@Module
public class PhoneModule {

    @Provides
    Battery providerBattery(){
        return new Battery();
    }

    @Provides
    Screen providerScreen(){
        return new Screen();
    }

}
