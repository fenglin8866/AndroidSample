package com.xxh.learn.kotlin.basic.annotation

class Book {
    var gallonsOfFuelInTank: Int = 15

    @MyTest("xtq")
    fun read(duration:Int){
        println("read book time:$duration")
    }
}


