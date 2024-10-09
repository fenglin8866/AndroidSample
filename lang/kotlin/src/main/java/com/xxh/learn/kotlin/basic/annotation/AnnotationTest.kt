package com.xxh.learn.kotlin.basic.annotation

import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.functions
import kotlin.reflect.full.hasAnnotation

class AnnotationTest {
    fun test() {
        val b = Book()
        val cla = b::class
        cla.functions.forEach {
            if(it.hasAnnotation<MyTest>()){
                val a=it.findAnnotation<MyTest>()
                println(a?.name)
            }
            /*it.findAnnotations<MyTest>().forEach { value ->
               println(value.name)
            }*/
        }
    }
}

fun main() {
    /*val a=AnnotationTest()
    a.test()*/
    val b= Book()
    b.gallonsOfFuelInTank
}