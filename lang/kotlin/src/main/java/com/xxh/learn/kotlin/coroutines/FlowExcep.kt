package coroutines

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i) // 发射下一个值
    }
}

fun simple2(): Flow<String> =
    flow {
        for (i in 1..3) {
            println("Emitting $i")
            emit(i) // 发射下一个值
        }
    }.map { value ->
        check(value <= 1) { "Crashed on $value" }
        "string $value"
    }

object FlowExcep {
    fun test() = runBlocking {
       /* try {
            simple2().collect { value ->
                println(value)
            }
        } catch (e: Throwable) {
            println("Caught $e")
        }*/
        simple2().catch {
            e->
            e.message?.let { emit(it) }
        }.collect{
                value ->
            println(value)
        }
    }
}