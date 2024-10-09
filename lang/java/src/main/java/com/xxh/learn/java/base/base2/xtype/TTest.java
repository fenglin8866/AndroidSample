package com.xxh.learn.java.base.base2.xtype;

import java.util.ArrayList;
import java.util.List;

public class TTest {
    public void test1(){
        //数组协变，
        Object[] objArr = new String[5];
        objArr[0] = 200;//运行报错，数组能存放的数据类型，仅和数组初始化时分配的数据类型一致


    }
    public void test2(){
        //编译异常，声明和赋值的类型不一致，怎么处理
        //List<Object> list = new ArrayList<String>();

        //只定义了上限，没下限，导致不能添加数据
        List<? extends Object> list = new ArrayList<String>();
       /* list.add("xx");
        list.add(2);*/

        //集合可以接收最小也是Fruit的元素，最大就不好言说了。所以向该集合添加Fruit以及Fruit子类的元素是被允许的
        List<? super Fruit> list2 = new ArrayList<Fruit>();
        list2.add(new Fruit());// compile correct
        list2.add(new Apple());// compile correct
        //list2.add(new Food());// compile error
    }

}
class Food {}
class Fruit extends Food {}
class Apple extends Fruit {}