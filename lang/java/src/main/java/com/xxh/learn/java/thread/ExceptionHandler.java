package com.xxh.learn.java.thread;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("==Exception: " + e.getMessage());
    }
}
