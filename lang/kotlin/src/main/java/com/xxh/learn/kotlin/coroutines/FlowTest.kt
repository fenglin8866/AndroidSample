package com.xxh.learn.kotlin.coroutines

import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext


/**
 *  private static final Function3 emitFun = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(new Function3() {
 *       // $FF: synthetic method
 *       // $FF: bridge method
 *       public Object invoke(Object var1, Object var2, Object var3) {
 *          return this.invoke((FlowCollector)var1, var2, (Continuation)var3);
 *       }
 *
 *       @Nullable
 *       public final Object invoke(@NotNull FlowCollector p1, @Nullable Object p2, @NotNull Continuation continuation) {
 *          return p1.emit(p2, continuation);
 *       }
 *    }, 3);
 */
private val emitFun =
    FlowCollector<Any?>::emit as Function3<FlowCollector<Any?>, Any?, Continuation<Unit>, Any?>

fun foo(): Flow<Int> = flow {
    for (i in 1..5) {
        println("Emitting $i")
        emit(i)
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



class  FlowTest {
    //Flow取消测试
    fun testCancel()= runBlocking {
        foo().collect { value ->
            if (value == 3)
                cancel()
            println(value)
        }

        foo().collect {
            if (it == 3)
                cancel()
            println(it)
        }

       /* (1..5).asFlow().collect { value ->
            if (value == 3) cancel()
            println(value)
        }

        (1..5).asFlow().cancellable().collect { value ->
            if (value == 3) cancel()
            println(value)
        }
        (1..5).asFlow().onEach { value ->
            currentCoroutineContext().ensureActive()
            if (value == 3) cancel()
            println(value)
        }.collect()*/
    }

    fun testExcept() = runBlocking {
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

    fun testEmitFun()= runBlocking {
        val c= FlowCollector<Any?> { value ->
            println(value)
        }
        val d= emitFun(c,"x",object :Continuation<Unit>{
            override val context: CoroutineContext
                get() = TODO("Not yet implemented")

            override fun resumeWith(result: Result<Unit>) {
                TODO("Not yet implemented")
            }

        })
    }

}



