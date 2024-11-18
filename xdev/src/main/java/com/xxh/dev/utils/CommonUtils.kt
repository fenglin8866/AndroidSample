package com.xxh.dev.utils

import android.annotation.SuppressLint
import android.util.Log

object CommonUtils {
    private var simInfoList: ArrayList<String>? = null


    @SuppressLint("PrivateApi")
    fun simInfo(): List<String> {
        if (simInfoList == null) {
            simInfoList = ArrayList()
            try {
                val systemPropertiesClass = Class.forName("android.os.SystemProperties")
                val method = systemPropertiesClass.getMethod("get", String::class.java)
                val value = method.invoke(null, "gsm.sim.operator.numeric") as String
                Log.i("xxh11","simInfoList value=$value")
                if (value.isNotEmpty()) {
                    val array = value.split(",")
                    array.forEach {
                        simInfoList?.add(it)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return simInfoList as List<String>
    }

}