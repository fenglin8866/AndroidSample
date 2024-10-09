package com.xxh.learn.java.base.base3.dagger7;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


@Module(subcomponents = PadComponent.class)
public class PhoneModule {
   // @Binds
    @Provides
     PadComponent.Factory provideFactory(){
         return new PadComponent.Factory() {
             @Override
             public PadComponent create(Pad instance) {
                 return null;
             }
         };
     }
}
