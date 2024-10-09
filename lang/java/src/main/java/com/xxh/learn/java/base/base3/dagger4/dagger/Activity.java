package com.xxh.learn.java.base.base3.dagger4.dagger;


import javax.inject.Inject;

public class Activity {

    @Inject
    public ActivityBean activityBean;

    @Inject
    public AppBean appBean;


    public Activity() {
        Application application= Application.getInstance();
        AppComponent appComponent= application.appComponent;
        appComponent.activityComponent().inject(this);
    }

    public void test() {
        System.out.println("a=" + activityBean + " b=" + appBean);
    }
}
