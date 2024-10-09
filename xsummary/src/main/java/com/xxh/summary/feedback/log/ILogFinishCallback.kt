package com.xxh.summary.feedback.log

@FunctionalInterface
interface ILogFinishCallback {
    fun finish(type: Result, filePath: String?, msg: String?)
}

enum class Result {
    SUCCESS, FAIL, INTERRUPT
}