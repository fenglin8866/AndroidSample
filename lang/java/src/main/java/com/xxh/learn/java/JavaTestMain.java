package com.xxh.learn.java;

import com.xxh.learn.java.basic.BasicTest;
import com.xxh.learn.java.daggertest.sample.Tool;
import com.xxh.learn.java.daggertest.sample.sub.People;
import com.xxh.learn.java.daggertest.sample.sub2.Man;
import com.xxh.learn.java.daggertest.sample.sub3.Woman;
import com.xxh.learn.java.daggertest.sample.sub4.Human;
import com.xxh.learn.java.daggertest.sample2.Work;
import com.xxh.learn.java.daggertest.test4.Test;
import com.xxh.learn.java.daggertest.test5.DaggerMyComponent2;
import com.xxh.learn.java.daggertest.test5.MyComponent2;

import java.util.HashSet;
import java.util.Set;


public class JavaTestMain {
    public static void javaMain() {
        System.out.println("java test");
        //BasicTest.test2();
        testDagger2();
    }
    public static void testDagger2() {
      /*  Test test=new Test();
        test.test();*/
        MyComponent2 component2= DaggerMyComponent2.create();
        component2.longsByString();
        component2.stringsByClass();

    }

    public static void testDagger() {
        Tool tool = new Tool();
        tool.run();
        print();
        People people=new People();
        people.run();
        print();
        Man man=new Man();
        man.run();
        print();
        Woman woman=new Woman();
        woman.run();
        print();
        Human human=new Human();
        human.run();
        print();
        Work work=new Work();
        work.test();
    }

    public static void print(){
        System.out.println("====================================================");
    }


    public static void test() {

        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("a");
        stringSet.add("b");
        stringSet.forEach(System.out::println);



      /*  String url="https://partners.sina.cn/html/nubia/article?docUrl=https%3A%2F%2Fk.sina.cn%2Farticle_1356168525_50d57d4d0010169ub.html%3Ffrom%3Dsports%26subch%3Dvollyball&en_dataid=3c5c9b0bd2ea4b5c5452ce94c5c8d9899fbb8f4f0a56949689ee5f6bf245e5f0&wm=6327";
        Pattern PATTERN_URL=Pattern.compile("//partners\\.sina\\.cn.*nubia/");

        boolean a=PATTERN_URL.matcher(url).find();
        System.out.println("a="+a);*/

       /* List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("d");
        stringList.add("e");
        stringList.add("f");
        stringList.add("g");
        stringList.add("h");

        stringList.add(2,"1");

        StringBuilder builder = new StringBuilder();

        for (String x: stringList) {
            builder.append(x).append(":");
        }
        System.out.println(builder.toString());


        Map<String, String> map = new HashMap<>();
        map.put("x","y");*/


        //System.out.println(map.);

        //TestMethodReferences.test1();
        //TestMethodReferences.test0();
        //TestFunctionProgress.test1();
       /* System.out.println("main");
        TestCompletedFuture.test();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        /*Set<String> stringSet = new HashSet<>();
        stringSet.add("1");
        stringSet.add("2");
        stringSet.add("1");
        stringSet.forEach(System.out::println);*/



        /*Map<String, String> map = new HashMap<>();
        map.putIfAbsent("a", "1");
        map.putIfAbsent("b", "2");
        map.putIfAbsent("c", "3");
        map.putIfAbsent("a", "4");
        Set<String> stringSet = new HashSet<>();
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("k=" + s + " v=" + s2);
                if (s.equals("a") || s.equals("b"))
                    stringSet.add(s);
            }
        });
        stringSet.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                map.remove(s);
            }
        });
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("k=" + s + " v=" + s2);

            }
        });*/

    }

}