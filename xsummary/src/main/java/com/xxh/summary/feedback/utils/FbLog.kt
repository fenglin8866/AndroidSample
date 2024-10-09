package com.xxh.summary.feedback.utils

import android.util.Log

object FbLog {
    private const val TAG = "feedback"
    private var debug = true

    fun debug(enable: Boolean) {
        debug = enable
    }

    fun d(tag: String, msg: String?) {
        if (debug) {
            Log.d(TAG, getMsg(tag, msg))
        }
    }

    fun i(tag: String, msg: String?) {
        Log.i(TAG, getMsg(tag, msg))
    }

    fun iDebug(tag: String, msg: String?) {
        if (debug) {
            Log.i(TAG, getMsg(tag, msg))
        }
    }

    fun w(tag: String, msg: String?) {
        Log.w(TAG, getMsg(tag, msg))
    }

    fun e(tag: String, msg: String?) {
        Log.e(TAG, getMsg(tag, msg))
    }

    private fun getMsg(tag: String, msg: String?): String {
        return "[$tag] $msg"
    }
}