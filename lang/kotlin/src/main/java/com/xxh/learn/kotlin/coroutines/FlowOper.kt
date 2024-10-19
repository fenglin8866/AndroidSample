package com.xxh.learn.kotlin.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun performRequest(request: Int): String {
    delay(1000) // 模仿长时间运行的异步任务
    return "response $request"
}

fun simple3(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i) // 发射下一个值
        emit(3)
    }
}


fun numbers(): Flow<Int> = flow {
    // try {
    emit(1)
    emit(2)
    println("This line will not execute")
    emit(3)
    /*} finally {
        println("Finally in numbers")
    }*/
}


//transform操作符
suspend fun transformTest() {
    (1..3).asFlow() // 一个请求流
        //可以发送任意次任意值,与flow的区别？
        .transform { request ->
            emit("Making request $request")
            emit(performRequest(request))
            emit(3)
        }
        .collect { response -> println(response) }

    //发射任意次固定类型值
    simple3().collect {
        println(it)
    }
}

suspend fun takeTest() {
    numbers().take(2).collect {
        println(it)
    }
}

suspend fun mapTest() {
    (1..5).asFlow()
        .filter {
            println("Filter $it")
            it % 2 == 0
        }
        .map {
            println("Map $it")
            "string $it"
        }.collect {
            println("Collect $it")
        }
}

fun simple4(): Flow<Int> = flow {
    for (i in 1..3) {
        Thread.sleep(100) // 假装我们以消耗 CPU 的方式进行计算
        log("Emitting $i")
        emit(i) // 发射下一个值
    }
}.flowOn(Dispatchers.Default) // 在流构建器中改变消耗 CPU 代码上下文的正确方式

suspend fun flowOnTest() {
    simple4().collect { value ->
        log("Collected $value")
    }
}

fun simple5(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(1000) // 假装我们异步等待了 100 毫秒
        intervalTime("simple5", startTime)
        emit(i) // 发射下一个值
    }
}

val startTime = System.currentTimeMillis()
suspend fun bufferTest() {
    val time = measureTimeMillis {
        simple5()
            .buffer() // 缓冲发射项，无需等待
            .collect { value ->
                delay(300) // 假装我们花费 300 毫秒来处理它
                println(value)
                intervalTime("bufferTest", startTime)
            }
    }
    println("Collected in $time ms")
/*
[xxh][main @coroutine#2]:simple5  time=45
[xxh][main @coroutine#2]:simple5  time=154
[xxh][main @coroutine#2]:simple5  time=259
1
[xxh][main @coroutine#1]:bufferTest  time=459
2
[xxh][main @coroutine#1]:bufferTest  time=764
3
[xxh][main @coroutine#1]:bufferTest  time=1070
Collected in 1050 ms
*/
}

suspend fun conflateTest() {
    val time = measureTimeMillis {
        simple5()
            .conflate() // 合并发射项，不对每个值进行处理
            .collect { value ->
                delay(300) // 假装我们花费 300 毫秒来处理它
                println(value)
                intervalTime("conflateTest", startTime)
            }
    }
    println("Collected in $time ms")

    /*
[xxh][main @coroutine#2]:simple5  time=44
[xxh][main @coroutine#2]:simple5  time=155
[xxh][main @coroutine#2]:simple5  time=257
1
[xxh][main @coroutine#1]:conflateTest  time=457
3
[xxh][main @coroutine#1]:conflateTest  time=763
Collected in 742 ms
     */
}

suspend fun collectLatestTest() {
    val time = measureTimeMillis {
        simple5()
            .collectLatest { value ->
                delay(3000) // 假装我们花费 300 毫秒来处理它
                println(value)
                intervalTime("conflateTest", startTime)
            }
    }
    println("Collected in $time ms")

}

suspend fun zipTest() {
//    val nums = (1..3).asFlow() // 数字 1..3
//    val strs = flowOf("one", "two", "three") // 字符串
//    nums.zip(strs) { a, b -> "$a -> $b" } // 组合单个字符串
//        .collect { println(it) } // 收集并打印

    val nums = (1..3).asFlow().onEach { delay(300) } // 发射数字 1..3，间隔 300 毫秒
    val strs = flowOf("one", "two", "three").onEach { delay(400) } // 每 400 毫秒发射一次字符串
    val startTime = System.currentTimeMillis() // 记录开始的时间
    nums.zip(strs) { a, b -> "$a -> $b" } // 使用“zip”组合单个字符串
        .collect { value -> // 收集并打印
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}

fun requestFlow(i: Int): Flow<String> = flow {
    log("requestFlow2")
    emit("$i: First")
    delay(500) // 等待 500 毫秒
    emit("$i: Second")
}

suspend fun flatMapTest(){
    val startTime = System.currentTimeMillis() // 记录开始时间
    (1..3).asFlow().onEach {
        delay(100)
        log("onEach")
    } // 每 100 毫秒发射一个数字
        //.map { requestFlow(it) }
//        .flatMapConcat {
        .flatMapMerge {
            log("requestFlow")
            requestFlow(it)
        }
        .collect { value -> // 收集并打印
            log("collect")
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
/*
[xxh][main @coroutine#2]:onEach
[xxh][main @coroutine#2]:requestFlow
[xxh][main @coroutine#3]:requestFlow2
[xxh][main @coroutine#1]:collect
1: First at 134 ms from start
[xxh][main @coroutine#2]:onEach
[xxh][main @coroutine#2]:requestFlow
[xxh][main @coroutine#4]:requestFlow2
[xxh][main @coroutine#1]:collect
2: First at 234 ms from start
[xxh][main @coroutine#2]:onEach
[xxh][main @coroutine#2]:requestFlow
[xxh][main @coroutine#5]:requestFlow2
[xxh][main @coroutine#1]:collect
3: First at 337 ms from start
[xxh][main @coroutine#1]:collect
1: Second at 641 ms from start
[xxh][main @coroutine#1]:collect
2: Second at 738 ms from start
[xxh][main @coroutine#1]:collect
3: Second at 846 ms from start
 */
}


object FlowOper {
    fun test() = runBlocking {
        //collectLatestTest()
        flatMapTest()
    }
}

fun main() {
    FlowOper.test()
}