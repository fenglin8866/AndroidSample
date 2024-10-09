package com.xxh.learn.kotlin.basic.test

class ObjectTest {
    //对象表达式
    fun test(){
        val t= FlowT()
       t.collect(object : IFlowCollector {
           override fun emit() {
              println("collect")
           }
       })

        t.collect{
            println("collect1")
        }
    }

}

//函数式接口
fun interface IFlowCollector {
     fun emit()
}

class FlowT {
    fun collect(collector: IFlowCollector) {
        collector.emit()
    }
}
