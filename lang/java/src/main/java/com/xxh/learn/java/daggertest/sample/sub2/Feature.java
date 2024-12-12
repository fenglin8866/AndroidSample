package com.xxh.learn.java.daggertest.sample.sub2;

public class Feature {

    private String feature;

    public Feature(String feature) {
        this.feature = feature;
    }

    public void run() {
        System.out.println("Feature " + feature);
    }

}
