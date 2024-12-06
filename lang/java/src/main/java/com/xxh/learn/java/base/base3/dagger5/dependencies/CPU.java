package com.xxh.learn.java.base.base3.dagger5.dependencies;

import javax.inject.Inject;

public class CPU {
    @Inject
    public CPU() {
    }

    @Override
    public String toString() {
        return "CPU";
    }
}
