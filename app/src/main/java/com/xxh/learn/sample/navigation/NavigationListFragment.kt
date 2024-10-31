package com.xxh.learn.sample.navigation

import android.content.Intent
import com.android.samples.donuttracker.DonutMainActivity
import com.example.android.navigationadvancedsample.NavigationSampleActivity
import com.xxh.basic.ListBaseFragment
import com.xxh.learn.fragment.NavigationFragmentActivity


class NavigationListFragment : ListBaseFragment(){
    override fun setData(): Array<String> = arrayOf(
        "NavigationFragment",
        "DonutTracker",
        "NavigationAdvancedSample",
    )

    override fun itemClickHandle(name: String) {
        val clazz: Class<*>? = when (name) {
            "NavigationFragment" -> NavigationFragmentActivity::class.java
            "DonutTracker" -> DonutMainActivity::class.java
            "NavigationAdvancedSample" -> NavigationSampleActivity::class.java
            else -> null
        }
        clazz?.let {
            startActivity(Intent(this.requireContext(),clazz))
        }
    }

}