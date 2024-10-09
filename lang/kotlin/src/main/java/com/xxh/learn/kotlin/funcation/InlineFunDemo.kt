package com.xxh.learn.kotlin.funcation

import kotlinx.coroutines.*

class InlineFunDemo {

    inline fun foo(a: String, b: String, test: (String, String) -> Unit) {
        test(a, b)
    }

}

/*
fun main() {
    val t = InlineFunDemo()
    t.foo("xxh", "ff", { a, b -> println(a + b) })

    t.foo("xxh", "ff", { a, b -> a+b+"xtq" })


}*/
val tl = ThreadLocal.withInitial { "initial" }

/*fun main() = runBlocking {
    println(tl.get()) // Will print "initial"
    // Change context
    withContext(tl.asContextElement("modified")) {
        println(tl.get()) // Will print "modified"
    }
    // Context is changed again
    println(tl.get()) // <- WARN: can print either "modified" or "initial"

    withContext(Dispatchers.IO) {
        //val value = threadLocal.getSafely() // Fail-fast in case of improper context
    }
}*/

public suspend inline fun <T> ThreadLocal<T>.getSafely(): T {
    ensurePresent()
    return get()
}

// Usage



fun test(int:Int){
    return
    var a:Int=2;
}
