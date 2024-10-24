package com.xxh.learn.sample.navigation

import android.content.Intent
import com.xxh.basic.ListBaseFragment


class NavigationListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "NavigationSample",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
           // "NavigationSample" -> NavigationMainActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}