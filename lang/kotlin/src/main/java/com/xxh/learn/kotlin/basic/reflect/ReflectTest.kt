package com.xxh.learn.kotlin.basic.reflect

import com.xxh.learn.kotlin.basic.reflect.Car

class ReflectTest {
    fun test(){
        val clazz= Car::class
        val c=::Car
        val car=c("xxh",23)
        val r= Car::run
        r(car,30)
        val b= Car::brand
        b.set(car,"xtq")
        println(car)
    }
}
