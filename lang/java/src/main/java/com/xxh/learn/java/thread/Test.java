package com.xxh.learn.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {
    public static void main(String[] args) {
        new Test().t4();
    }

    //线程池中Runnable和Callable运行封装UncaughtExceptionHandler
    private void t1(){
        ExecutorService exec = Executors.newCachedThreadPool();
        Thread thread = new Thread(new ThreadPoolTask());
        exec.execute(thread);
        exec.shutdown();
    }

    //线程池中线程封装UncaughtExceptionHandler无效
    private void t2(){
        ExecutorService exec = Executors.newCachedThreadPool();
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        exec.execute(thread);
        exec.shutdown();
    }

    private void t3(){
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new Task());
        exec.shutdown();

    }
    //submit，线程中所有类型异常作为返回的一部分，封装在Future.get的ExecutionException中
    private void t4(){
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> f= exec.submit(new Task());
        try {
            f.get();
        } catch (InterruptedException | ExecutionException e) {
            //throw new RuntimeException(e);
            System.out.println("==Exception: "+e.getMessage());
        }
        exec.shutdown();
    }


}
