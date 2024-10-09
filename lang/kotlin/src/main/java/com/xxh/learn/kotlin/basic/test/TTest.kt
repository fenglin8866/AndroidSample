package com.xxh.learn.kotlin.basic.test

class TTest {
    inline fun <reified T> backupLoot(l: ALoot, t: T) {
        val c=T::class
        if (l is T) {
            println("ALoot")
        } else {
            println("BLoot")
        }
    }
}

interface Loot

class ALoot : Loot

class BLoot : Loot


class St{

    fun list(){
        val x= HashMap<String, String>()
        for((k,v) in x){
            println("k=$k v=$v")
        }
    }

    class In{
        fun i(){
            println(name)
        }
    }
    companion object{
        val name=""
    }
}
