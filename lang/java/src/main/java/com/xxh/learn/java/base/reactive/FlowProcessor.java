package com.xxh.learn.java.base.reactive;/*
package base.reactive;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowProcessor extends SubmissionPublisher<String> implements Flow.Processor<String,String>{
    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        System.out.println("Processor 建立订阅关系");
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(String item) {
        System.out.println("Processor 接收数据: " + item);
        item += " Processor 处理后的消息";
        this.submit(item);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("Processor 数据接收出现异常，error :" + throwable.getMessage());
        this.subscription.cancel();
    }

    @Override
    public void onComplete() {
        System.out.println("Processor 数据处理完成");
    }
}
*/
