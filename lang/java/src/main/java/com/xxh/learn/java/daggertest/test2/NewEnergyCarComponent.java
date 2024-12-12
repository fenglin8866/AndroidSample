package com.xxh.learn.java.daggertest.test2;

import dagger.Subcomponent;

@Subcomponent(modules = {NewEnergyCarModel.class})
public interface NewEnergyCarComponent {
    void inject(NewEnergyCar car);
}
