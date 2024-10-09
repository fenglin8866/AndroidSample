package com.xxh.learn.kotlin.a327

class CommonFunTest {
    fun test() {
        //顶层函数
        kotlin.run {

        }
        //作用域是当前所在的类对象
        run {

        }
        //作用域是当前所在的类对象
        apply {

        }
        //作用域是当前调用对象
        User().apply {
            school = ""
        }

        User().also {
            println(it)
        }


        repeat(22) {

        }

        User().applyX1 {
           // school=
        }
    }

    fun f1() {
        fA {
            "x"
        }
        fB {
            "x"
        }
    }
}

fun fA(block:()->String){
    block()
}
fun fB(block:(String)->String){
    block("xxh")
}




object book {
    fun b() {
        apply {

        }
    }
}

fun f2() {
    run {

    }
}


data class User(val name: String = "", val age: Int = 18) {
    var school: String = "未知"

    constructor(name: String, age: Int, school: String) : this(name, age) {
        this.school = school
    }
}

//block对应的lambda内部不能使用T的成员
inline fun <T> T.applyX1(block: () -> Unit): T {
    block()
    return this
}

//函数内部必须构建T的对象，才能调用block函数
inline fun <reified T> applyX2(block: T.() -> Unit): T? {
    val t:T?=T::class.objectInstance
    t?.block()
    return t
}

//最简洁，T对象直接调用该方法就可以
inline fun <T> T.applyX(block: T.() -> Unit): T {
    block()
    return this
}



fun <T> T.also(block: (T) -> Unit):T{
    block(this)
    return this
}

fun <R> run(block:()->R):R{
    return block()
}

fun <T, R> T.run(block: T.() -> R): R {
    return block()
}



fun <T> T.alsoX(block: (T) -> Unit): T {
    //block
    block(this)
    return this
}

fun <R> runX(block: () -> R): R {
    return block()
}

fun <T, R> T.runX(block: T.() -> R): R {
    return block()
}

fun <T, R> T.letX(block: (T) -> R): R {
    return block(this)
}

fun <T, R> withX(receiver: T, block: T.() -> R): R {
    return receiver.block()
}


/**
 * 作用域函数
 * 分类：
 * 顶层函数：run,repeat
 * 扩展函数：apply,also,with,run,let,takeIf,takeUnless
 *
 * 调用场景：
 * 顶层函数：直接调用只能是顶层函数run和repeat
 * 类内：直接调用可以是顶层函数也可以是扩展函数（作用域是当前所在类对象this）
 *
 * run
 * with
 * apply ：侧重点：对上下文对象成员的操作
 * also ：侧重点：将上下文对象作为参数的操作，而不是其成员的操作
 * let
 * repeat
 * takeIf
 * takeUnless
 */
