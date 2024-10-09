package com.xxh.learn.java.base.base2.xenum;

public class Season1 {
    public static Season1 SPRING = new Season1("春天", "温暖");
    public static Season1 SUMMER = new Season1("夏天", "炎热");
    public static Season1 AUTUMN = new Season1("秋天", "凉爽");
    public static Season1 WINTER = new Season1("冬天", "寒冷");
    private String name;
    private String desc;

    private Season1(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }
}
