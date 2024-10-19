package com.xxh.learn.sample.sample

import android.content.Intent
import com.android.example.github.BrowserMainActivity
import com.xxh.basic.ListBaseFragment


class SampleListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "GithubBrowser",
        "ToDo",
        "SunFlow",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "GithubBrowser" -> BrowserMainActivity::class.java
            "ToDo" -> null
            "SunFlow" -> null
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}