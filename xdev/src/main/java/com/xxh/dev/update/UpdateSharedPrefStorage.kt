package com.xxh.dev.update

import android.content.Context

class UpdateSharedPrefStorage(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("update", Context.MODE_PRIVATE)

    fun setString(key: String, value: String) {
        with(sharedPreferences.edit()) {
            putString(key, value)
            apply()
        }
    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key, "")!!
    }
}