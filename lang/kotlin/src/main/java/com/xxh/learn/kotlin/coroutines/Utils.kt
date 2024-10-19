package com.xxh.learn.kotlin.coroutines

fun log(msg: String, tag: String = "xxh") {
    println("[$tag][${Thread.currentThread().name}]:$msg")
}

fun intervalTime(msg: String = "", startTime: Long) {
    log(msg = "$msg  time=${System.currentTimeMillis() - startTime}")
}
