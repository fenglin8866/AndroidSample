package com.xxh.learn.kotlin.basic.test


inline fun foo(block: () -> Unit) {
    println("foo1")
    block()
    println("foo2")
}

fun main() {
    play()
    play2 {
        //return  //编译错误
        return@play2
    }
    play3 {
        return
    }

}

fun localReturn() {
    return
}

fun play() {
    println("playA")
    localReturn()//局部返回
    println("playB")
}

//Lambda表达式不允许存在return关键字
fun play2(local: () -> Unit) {
    println("playA1")
    local()
    println("playB1")
}

//与局部返回不同，inline会导致return直接保留在调用位置，直接退出，动作后面代码允许
inline fun play3(local: () -> Unit) {
    println("playA3")
    local()
    println("playB3")
}


class Test2 {

}