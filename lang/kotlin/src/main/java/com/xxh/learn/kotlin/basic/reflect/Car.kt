package com.xxh.learn.kotlin.basic.reflect

data class Car(var brand: String, var age: Int) {
    fun work() {
        println("car brand=$brand age=$age")
    }

    fun run(speed: Int) {
        println("car speed=$speed")
    }
}