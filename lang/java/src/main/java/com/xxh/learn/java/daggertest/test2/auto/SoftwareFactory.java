package com.xxh.learn.java.daggertest.test2.auto;

import com.xxh.learn.java.daggertest.test2.Software;
import com.xxh.learn.java.daggertest.test2.SoftwareModel;

import dagger.internal.Factory;

public class SoftwareFactory implements Factory<Software> {
    private final SoftwareModel softwareModel;

    public SoftwareFactory(SoftwareModel softwareModel) {
        this.softwareModel = softwareModel;
    }

    public static SoftwareFactory create(SoftwareModel softwareModel) {
        return new SoftwareFactory(softwareModel);
    }


    @Override
    public Software get() {
        return provideSoftware(softwareModel);
    }

    public static Software provideSoftware(SoftwareModel softwareModel) {
        return softwareModel.provideSoftware();
    }

}
