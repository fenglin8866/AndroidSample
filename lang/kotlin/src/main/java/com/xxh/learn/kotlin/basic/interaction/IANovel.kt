package com.xxh.learn.kotlin.basic.interaction

interface IANovel {
    fun getRecom(count: Int, callback: (List<String>) -> Unit)
}