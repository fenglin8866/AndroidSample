package com.xxh.learn.kotlin.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class CoroutineTest3 :CoroutineScope{
    fun test1() = runBlocking {
        launch {

        }

        coroutineScope {

        }

        val x = async {

        }

        launch {

        }

        withTimeout(2000){

        }

        withContext(Dispatchers.IO){

        }
    }

     suspend fun test2()  {
         delay(11)
         launch {

        }
    }

    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")

}