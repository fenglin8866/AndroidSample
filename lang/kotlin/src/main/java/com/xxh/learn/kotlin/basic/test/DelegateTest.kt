package com.xxh.learn.kotlin.basic.test

class DelegateTest {
    fun test() {
        val b = BaseImp("xxh")
        val derived = Derived(b)
        derived.printName()
        derived.printNameLine()
        derived.printMessage()
    }
}

interface Base {
    val msg: String
    fun printName()
    fun printNameLine()
    fun printMessage()
}

class BaseImp(private val name: String) : Base {
    override val msg: String
        get() = "BaseImp msg"

    override fun printName() {
        println(name)
    }

    override fun printMessage() {
        println(msg)
    }

    override fun printNameLine() {
        println(name)
    }
}

/**
 * kotlin 委托实现，通过by子句减少模板代码，等同如下代码
 * class Derived(private val base: Base) : Base {
 *     override fun printName() {
 *         base.printName()
 *     }
 * }
 */
class Derived(b: Base) : Base by b {

    /**
     * 覆盖属性，但委托对象无法访问，只能访问还是其自身属性
     */
    override val msg: String
        get() = "Derived msg"

    /**
     * 重写接口实现，对应的委托接口覆盖
     */
    override fun printNameLine() {
        println("xtq")
    }
}

