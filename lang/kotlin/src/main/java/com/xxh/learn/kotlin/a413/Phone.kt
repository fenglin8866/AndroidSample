@file:JvmName("Factory")
package com.xxh.learn.kotlin.a413

@JvmName("product")
fun People.product(phone: Phone){
    println("${this.name} 生产${phone.bland}")
}

class Phone (val bland:String)