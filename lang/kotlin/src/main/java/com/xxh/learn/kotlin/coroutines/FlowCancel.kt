package coroutines

import kotlinx.coroutines.cancel
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun foo(): Flow<Int> = flow {
    for (i in 1..5) {
        println("Emitting $i")
        emit(i)
    }
}

object  FlowCancel {
    fun test()= runBlocking {
        foo().collect { value ->
            if (value == 3)
                cancel()
            println(value)
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
}