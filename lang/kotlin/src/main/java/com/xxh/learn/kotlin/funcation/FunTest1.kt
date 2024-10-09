package com.xxh.learn.kotlin.funcation

class FunTest1 {
}

open class A {
    open fun a(a: Int = 3) {
        println("A:a()")
    }
}

class B : A() {
    override fun a(a: Int) {
        //super.a(a)
    }
}