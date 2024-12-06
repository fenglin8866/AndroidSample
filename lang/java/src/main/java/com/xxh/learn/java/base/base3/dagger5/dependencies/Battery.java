package com.xxh.learn.java.base.base3.dagger5.dependencies;

import javax.inject.Inject;

public class Battery {
    @Inject
    public Battery() {
    }

    @Override
    public String toString() {
        return "Battery";
    }
}
