package com.xxh.learn.java.base.base3.dagger4;

import javax.inject.Inject;

public class Activity {

    @Inject
    public ActivityBean activityBean;

    @Inject
    public AppBean appBean;


    public Activity() {
        Application application = Application.getInstance();
        DaggerActivityComponent.builder().appComponent(application.appComponent).build().inject(this);
//        DaggerActivityComponent.builder().build().inject(this);
    }

    public void test() {
        System.out.println("a=" + activityBean + " b=" + appBean);
    }
}
