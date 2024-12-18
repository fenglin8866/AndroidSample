package com.example.dagger3.di;

import com.example.dagger3.HomeActivity;
import com.example.dagger3.data.CarRepository;
import com.example.dagger3.data.CarResource;


import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {
    /**
     * 作用域标注在该方法与标注在构造方法中是一样的。
     * @param carRepository
     * @return
     */
    @Singleton
    @Binds
    abstract CarResource carResource(CarRepository carRepository);

    /**
     *  ContributesAndroidInjector:使用modules生成一个SubComponent
     *  SubComponent继承于AndroidInjector<T> ,T表示对应的android组件。
     *  SubComponent会自动被当前Module声明为子组件。
     *  ============================================================
     *  ContributesAndroidInjector 生成一个
     *  @Subcomponent(modules = {AndroidInjectionModule.class})
     * public interface MainComponent extends AndroidInjector<MainActivity> {
     *
     *     @Subcomponent.Factory
     *     interface Factory extends AndroidInjector.Factory<MainActivity> {
     *
     *     }
     * }
     *
     * @return
     */
    @ActivityScoped
    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity homeActivity();
}
