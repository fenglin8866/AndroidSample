package com.xxh.learn.kotlin.basic.annotation

class Book2(val name:String="java",val page:Int){
    fun inder(){
        println("book2 name$name page:$page")
    }
}

/**
 * val b2=Book2(page = 354)
 *
 * new Book2((String)null, 354, 1, (DefaultConstructorMarker)null);
 *
 * public Book2(String var1, int var2, int var3, DefaultConstructorMarker var4) {
 *       if ((var3 & 1) != 0) {
 *          var1 = "java";
 *       }
 *
 *       this(var1, var2);
 *    }
 */