package com.xxh.learn.java.basic;

import java.util.ArrayList;
import java.util.function.Consumer;

public class BasicTest {

    /**
     * 一个集合放入另一个集合，放入的是集合引用还是元素？
     * 验证：是元素
     */
    public static void test2() {
        ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        ArrayList<String> list2=new ArrayList<>();
        list2.add("1");
        list2.add("2");
        list2.add("3");
        list2.addAll(list);
        list.clear();
        System.out.println("list size="+list.size());
        System.out.println("list2 size="+list2.size());
        list2.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("list2 s="+s);
            }
        });
    }
}
