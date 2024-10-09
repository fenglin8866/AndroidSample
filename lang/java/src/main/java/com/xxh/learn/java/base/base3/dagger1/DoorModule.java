package com.xxh.learn.java.base.base3.dagger1;

import dagger.Module;
import dagger.Provides;

@Module
public class DoorModule {
    @Provides
    public Door provideDoor(int mun){
        return new Door(mun);
    }

    @Provides
    public int provideNum(){
        return 4;
    }

}
