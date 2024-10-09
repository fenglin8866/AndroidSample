package com.xxh.learn.java.base.reactive;/*
package base.reactive;

import java.util.concurrent.Flow;

public class MySubscriber implements Flow.Subscriber<String>{
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Subscriber create subscription");
        //发布订阅关系
        this.subscription = subscription;
        //请求一个数据
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {

        System.out.println("subscriber accept msg: " + item);
        //接收数据后 再请求一个数据
        this.subscription.request(1);
        //不再接收数据，调用cancel
        // this.subscription.cancel();
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("subscriber error :" + throwable.getMessage());
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("subscriber complete");
    }
}
*/
