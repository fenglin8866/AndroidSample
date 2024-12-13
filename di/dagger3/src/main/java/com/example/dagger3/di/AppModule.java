package com.example.dagger3.di;

import com.example.dagger3.data.CarRepository;
import com.example.dagger3.data.CarResource;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

@Module(subcomponents = HomeActivityComponent.class)
public abstract class AppModule {
    /**
     * 作用域标注在该方法与标注在构造方法中是一样的。
     * @param carRepository
     * @return
     */
    @Singleton
    @Binds
    abstract CarResource carResource(CarRepository carRepository);
}
