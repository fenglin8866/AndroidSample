package com.xxh.learn.java.base.base3.dagger3;

public class CarShop {

//    @Named("A")
//    @Inject
//    public Car carA;
//
//    @Inject
//    public Car carB;

    public CarShop() {
//        DaggerCarComponent.create().inject(this);
        DaggerBossComponent.builder().tag("sss").build();
    }

    public void test(){
//        System.out.println(carA+" b="+carB);
    }

}
