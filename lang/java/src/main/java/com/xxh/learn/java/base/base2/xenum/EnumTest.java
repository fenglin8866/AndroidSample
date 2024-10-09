package com.xxh.learn.java.base.base2.xenum;

import java.util.Arrays;
import java.util.function.Consumer;

public class EnumTest {
    public void test() {
        Season s1=Season.WINTER;
        System.out.println(s1.name());
        System.out.println(s1.ordinal());
        System.out.println(s1.compareTo(Season.SUMMER));
        System.out.println(Season.valueOf("SUMMER"));
        System.out.println("==============================");

        Arrays.stream(Season.values()).forEach(new Consumer<Season>() {
            @Override
            public void accept(Season season) {
                System.out.println(season+"");
            }
        });
    }
}




