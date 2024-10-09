package com.xxh.learn.java.base.base2.xtype;

public class CompareData<T> {
    private T t1;
    private T t2;
    public boolean compare(){
        return t1==t2;
    }

    //public static void test(T t){}

    public <F> boolean compare(F f1,F f2){
        return f1==f2;
    }

}
