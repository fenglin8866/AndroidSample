package com.xxh.learn.java.base.reactive;/*
package base.reactive;

import java.util.concurrent.Flow;

*/
/**
 * defaultBufferSize的默认值可以提供一个有用的起点，用于根据预期的速率、资源和使用情况选择Flow组件中的请求大小和容量。
 * 或者，当不需要流量控制时，订阅者最初可以请求一个有效的不限数量的项目
 * @param <T>
 *//*

public class UnboundedSubscriber<T> implements Flow.Subscriber<T> {
    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        subscription.request(Long.MAX_VALUE); // effectively unbounded
    }

    @Override
    public void onNext(T item) {
        //use(item);
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.printStackTrace();
    }

    @Override
    public void onComplete() {

    }
}
*/
