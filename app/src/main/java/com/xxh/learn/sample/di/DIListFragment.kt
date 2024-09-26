package com.xxh.learn.sample.di

import android.content.Intent
import com.example.android.dagger.main.LoginMainActivity
import com.example.android.hilt.ui.LogsActivity
import com.xxh.basic.ListBaseFragment

class DIListFragment : ListBaseFragment() {
    override fun setData(): Array<String> = arrayOf(
        "Hilt之Logs",
        "Hilt之Login",
        "Dagger",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "Hilt之Logs" -> LogsActivity::class.java
            "Hilt之Login" -> LoginMainActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}