package com.xxh.learn.java.base.base2.xenum;

public enum Season {
    SPRING("春天","温暖"), SUMMER("夏天","炎热"),AUTUMN("秋天","凉爽"), WINTER("冬天","寒冷");
    private String name;
    private String desc;

    Season(String name, String desc) {
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
